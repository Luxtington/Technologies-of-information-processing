package ru.luxtington.reflection.base.other;

import ru.luxtington.annotations.Invoke;
import ru.luxtington.annotations.Validate;
import ru.luxtington.oop.geometry.figures.Line;
import ru.luxtington.oop.geometry.points.Point2D;
import ru.luxtington.oop.geometry.points.Point3D;
import ru.luxtington.reflection.base.testSystem.TestValidationException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Reflector {

    @Invoke
    public static int findEmptyConstructorIndex(Class<?> cl){ // my util
        int emptyConstructorIndex = 0;
        Constructor<?>[] constructors = cl.getDeclaredConstructors();
        for (int i=0; i < constructors.length; i++){
            if (constructors[i].getParameterCount() == 0){
                emptyConstructorIndex = i;
                break;
            }
        }
        return emptyConstructorIndex;
    }

    @Invoke
    public static List<Field> fieldCollection(Class<?> cl){
        List<Field> res = new ArrayList<>();

        while (cl != null){
            res.addAll(List.of(cl.getDeclaredFields()));
            cl = cl.getSuperclass();
        }

        return res;
    }

    public static void lineConnector(Line<Point2D> l1, Line<Point2D> l2) throws Exception {

        Field end1 = l1.getClass().getDeclaredField("endPoint");
        end1.setAccessible(true);
        Field begin2 = l2.getClass().getDeclaredField("beginPoint");
        begin2.setAccessible(true);
        begin2.set(l2, end1.get(l1));

        end1.setAccessible(false);
        begin2.setAccessible(false);
    }

    public static void validate(Object...objs){
        List<Object> objects = List.of(objs);

        for (Object o : objects) {
            if (!(o.getClass().isAnnotationPresent(Validate.class))
                    && !(Arrays.stream(o.getClass().getAnnotations()).anyMatch(annotation -> annotation.annotationType().isAnnotationPresent(Validate.class)))) {
                System.out.println("Warning: Object of type " + o.getClass().getSimpleName()
                        + " isn't ready for testing, it hasn't pinned classes for tests");
                continue;
            }
            List<Class<?>> testClasses;

            if (o.getClass().isAnnotationPresent(Validate.class)){
                testClasses = List.of(o.getClass().getAnnotation(Validate.class).value());
            } else {
                Annotation an = Arrays.stream(o.getClass().getAnnotations())
                        .filter(annotation -> annotation.annotationType().isAnnotationPresent(Validate.class))
                        .findFirst().orElse(null); // по сути null никогда не будет
                testClasses = List.of(an.annotationType().getAnnotation(Validate.class).value());
            }

            Map<Method, Throwable> objectLogs = new HashMap<>();

            for (Class<?> testClass : testClasses){
                Constructor<?> constructor = testClass.getDeclaredConstructors()[0];

                for (Method m : testClass.getDeclaredMethods()) {
                    try {
                        m.setAccessible(true);
                        m.invoke(constructor.newInstance(o));
                        m.setAccessible(false);
                    } catch (Exception e) {
                        objectLogs.put(m, e.getCause());
                    }
                }
            }
            if (!objectLogs.isEmpty()) {
                StringBuilder res = new StringBuilder(System.lineSeparator());
                for (Method m : objectLogs.keySet()) {
                    if (objectLogs.get(m) != null)  // есть метод, но нет сообщения
                        res.append("In method " + m.getName() + ": " + objectLogs.get(m).getMessage() + System.lineSeparator());
                }
                throw new TestValidationException(res.toString());
            }
        }
    }


//    public static void validate(Object object, Class<?> testClass){
//        Map<Method, Throwable> logs = new HashMap<>();
//
//        Method [] methods = testClass.getDeclaredMethods();
//
//        Constructor<?> constructor = testClass.getDeclaredConstructors()[0];
//
//        for (Method m : methods){  // invocation target
//            try{
//                m.setAccessible(true);
//                m.invoke(constructor.newInstance(object));
//                m.setAccessible(false);
//            } catch (Exception e){
//                logs.put(m, e.getCause());
//            }
//        }
//        if (!logs.isEmpty()){
//            StringBuilder res = new StringBuilder(System.lineSeparator());
//            for (Method m : logs.keySet()){
//                if (logs.get(m) != null)  // есть метод, но нет сообщения
//                    res.append("In method " + m.getName() + ": " + logs.get(m).getMessage() + System.lineSeparator());
//            }
//            throw new TestValidationException(res.toString());
//        }
//    }

    @Invoke
    public static int getRandomNum(){
        Random r = new Random();
        return r.nextInt();
    }
}
