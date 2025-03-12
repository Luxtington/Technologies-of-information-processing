package ru.luxtington.reflection.hard;

import ru.luxtington.annotations.Default;
import ru.luxtington.annotations.DefaultValuesHolder;
import ru.luxtington.annotations.Invoke;
import ru.luxtington.reflection.base.other.Reflector;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ClassWithUtils {
    public static Map<String, Object> collect(List<Class<?>> classes) throws Exception {

        Map<String, Object> res = new HashMap<>();

        for (Class<?> cl : classes){
            List<Method> methods = List.of(cl.getDeclaredMethods());
            for (Method m : methods){
                m.setAccessible(true);
                if (m.isAnnotationPresent(Invoke.class) && (!m.getReturnType().equals(void.class))
                    && m.getParameterCount() == 0){
                    int index = Reflector.findEmptyConstructorIndex(cl);
                        res.put(m.getName(), m.invoke(cl.getDeclaredConstructors()[index].newInstance()));
                }
                m.setAccessible(false);
            }
        }
        return res;
    }

    public static void reset(Object... objs) throws Exception {
        List<Object> objects = List.of(objs);

        for (Object o : objects) {
            Class<?> currCl = o.getClass();
            while (currCl != null && !currCl.isInterface() && !Modifier.isAbstract(currCl.getModifiers())) {
                if (!currCl.isAnnotationPresent(Default.class)) {
                    fillFieldsAsDefault(List.of(currCl.getDeclaredFields()), o);
                } else {
                    List<Field> objectFields = List.of(currCl.getDeclaredFields());
                    for (Field f : objectFields) {
                        matchFieldWithDefaultFields(o, f);
                    }
                }
                currCl = currCl.getSuperclass();
            }
        }
    }

    private static void matchFieldWithDefaultFields(Object object, Field objF) throws Exception {
        List<Field> def = List.of(object.getClass().getAnnotation(Default.class).value().getDeclaredFields());
        for (Field f : def){
            f.setAccessible(true);
            if (f.getType() == objF.getType()){
                objF.setAccessible(true);
                objF.set(object, f.get(DefaultValuesHolder.class.getDeclaredConstructors()[0].newInstance()));
                objF.setAccessible(false);
                f.setAccessible(false);
                break;
            }
            f.setAccessible(false);
        }
    }

    private static void fillFieldsAsDefault(List<Field> flds, Object o) throws Exception {
        for (Field fi : flds){
            if (fi.isAnnotationPresent(Default.class))
                matchFieldWithDefaultFields(o, fi);
        }
    }
}

