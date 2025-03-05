package ru.luxtington.reflection.base.testSystem;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestExecutor{
    static Map<Method, Throwable> logs = new HashMap<>();

    public static void execute(Class<?>...classes) throws Exception {
        List<Class<?>> cls = List.of(classes);
        for (Class<?> cl : cls){
            Constructor<?> constr = cl.getDeclaredConstructors()[0];
            for (Method m : cl.getDeclaredMethods()){
                try{
                    m.invoke(constr.newInstance()); // remake
                } catch (Exception e){
                    logs.put(m, e.getCause());
                }

            }
        }
        if (!logs.isEmpty())
            for (Method m : logs.keySet())
                System.out.println("In method " + m.getName() + ": " + logs.get(m));
    }

}
