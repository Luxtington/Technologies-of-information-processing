package ru.luxtington.reflection.base.other;

import ru.luxtington.annotations.Cache;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class Cacher {
    public static <T> List<T> cache(T... objs) throws Exception {

        List<T> objects = List.of(objs);
        List<T> res = new ArrayList<>();

        for (T obj : objects){
            Class<?> cl = obj.getClass();
            res.add((T) Proxy.newProxyInstance(
                    cl.getClassLoader(),
                    cl.getInterfaces(),
                    new CacheHandler<>(obj)
            ));
        }
        return res;
    }

    private static class CacheHandler<T> implements InvocationHandler {
        private final T originalObject;
        private final Map<Method, Object> cacheMap = new HashMap<>();
        private final Map<Field, Object> fieldsCache = new HashMap<>();
        private boolean isUpdated = true;
        private boolean isAnnotatedByCache = false;

        public CacheHandler(T originalObject) throws Exception {
            this.originalObject = originalObject;

            if (originalObject.getClass().isAnnotationPresent(Cache.class))
                isAnnotatedByCache = true;

            for (Field f : originalObject.getClass().getDeclaredFields()){
                f.setAccessible(true);
                fieldsCache.put(f, f.get(originalObject));
                f.setAccessible(false);
            }
        }

        private boolean wasFieldsUpdated() throws Exception {  // were updated => true
            boolean fl = false;
            for (Field f : originalObject.getClass().getDeclaredFields()){
                f.setAccessible(true);
                if (f.get(originalObject) != fieldsCache.get(f)){
                    fl = true;
                    fieldsCache.put(f, f.get(originalObject));
                    f.setAccessible(false);
                }
            }
            return fl;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (isAnnotatedByCache && originalObject.getClass().getAnnotation(Cache.class).value().length == 0){
                if (wasFieldsUpdated()){
                    isUpdated = true;
                    cacheMap.clear();
                }

                // есть параметры - не кэшируем
                if (method.getParameterCount() > 0){
                    method.setAccessible(true);
                    Object res = method.invoke(originalObject, args);
                    method.setAccessible(false);
                    return res;
                }

                // при апдейте кладем новое в мапу
                if (isUpdated) {
                    method.setAccessible(true);
                    Object result = method.invoke(originalObject, args);
                    cacheMap.put(method, result);
                    isUpdated = false;
                    method.setAccessible(false);
                    return result;
                }
                else{ // isUpdated = false
                    if (cacheMap.get(method) == null){
                        method.setAccessible(true);
                        cacheMap.put(method, method.invoke(originalObject, args));
                        method.setAccessible(false);
                    }
                    return cacheMap.get(method);
                }

            } else if ((isAnnotatedByCache && originalObject.getClass().getAnnotation(Cache.class).value().length != 0)){
                if (wasFieldsUpdated()){
                    isUpdated = true;
                    cacheMap.clear();
                }

                // есть параметры/метод не задан аннотацией - не кэшируем
                if (method.getParameterCount() > 0 || !List.of(originalObject.getClass().getAnnotation(Cache.class).value()).contains(method.getName())){
                    method.setAccessible(true);
                    Object res = method.invoke(originalObject, args);
                    method.setAccessible(false);
                    return res;
                }

                // при апдейте очищаем кэш
                if (isUpdated) {
                    method.setAccessible(true);
                    Object result = method.invoke(originalObject, args);
                    cacheMap.put(method, result);
                    isUpdated = false;
                    method.setAccessible(false);
                    return result;
                }
                else{ // isUpdated = false
                    if (cacheMap.get(method) == null){
                        method.setAccessible(true);
                        cacheMap.put(method, method.invoke(originalObject, args));
                        method.setAccessible(false);
                    }
                    return cacheMap.get(method);
                }
            } else {
                method.setAccessible(true);
                Object res = method.invoke(originalObject, args);
                method.setAccessible(false);
                return res;
            }
        }
    }
}