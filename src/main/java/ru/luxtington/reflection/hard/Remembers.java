package ru.luxtington.reflection.hard;

import ru.luxtington.annotations.Default;
import ru.luxtington.annotations.DefaultValuesHolder;
import ru.luxtington.annotations.Invoke;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Remembers {
    public static Map<String, Object> collect(List<Class<?>> cls) throws Exception {
        Map<String, Object> res = new HashMap<>();
        for (Class<?> cl : cls){
            List<Method> methods = List.of(cl.getDeclaredMethods());

            for (Method m : methods){
                m.setAccessible(true);
                if (m.getParameterCount() == 0 && !m.getReturnType().equals(void.class)
                        && m.isAnnotationPresent(Invoke.class)){
                    res.put(m.getName(), m.invoke(cl.getDeclaredConstructors()[0].newInstance()));
                }
                m.setAccessible(false);
            }
        }
        return res;
    }

    public static void reset(Object object) throws Exception {
        Class<?> currCl = object.getClass();
        while (currCl != null) {
            if (currCl.isAnnotationPresent(Default.class)) {
                List<Field> fields = List.of(currCl.getDeclaredFields());
                for (Field f : fields) {
                    setValueAsDefault(f, object, currCl.getAnnotation(Default.class).value());
                }
            }
            currCl = currCl.getSuperclass();
        }
    }

    private static void setValueAsDefault(Field f, Object o, Class<?> handler) throws Exception {
        for (Field fi : handler.getDeclaredFields()){
            fi.setAccessible(true);
            if (f.getType().equals(fi.getType())){
                f.setAccessible(true);
                f.set(o, fi.get(DefaultValuesHolder.class.getDeclaredConstructors()[0].newInstance()));
                f.setAccessible(false);
                fi.setAccessible(false);
                return;
            }
            fi.setAccessible(false);
        }
    }
}
