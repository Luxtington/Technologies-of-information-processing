package ru.luxtington.reflection.base.other;

import ru.luxtington.annotations.Cache;
import ru.luxtington.annotations.Mutator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

@SuppressWarnings("unchecked")
public class UpCacher {
    public static <T> List<T> cache(T... objs) throws Exception {

        List<T> objects = List.of(objs);
        List<T> res = new ArrayList<>();

        for (T obj : objects){
            Class<?> cl = obj.getClass();
            res.add((T) Proxy.newProxyInstance(
                    cl.getClassLoader(),
                    cl.getInterfaces(),
                    new UpCacher.UpProxyHandler<T>(obj)
            ));
        }
        return res;
    }

    private static class UpProxyHandler<T> implements InvocationHandler {
        private Object object;
        private Map<Key, Object> cache = new HashMap<>();

        public UpProxyHandler(Object object) {
            this.object = object;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            method = object.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());

            if (method.isAnnotationPresent(Mutator.class)){cache.clear();}

            if (!method.isAnnotationPresent(Cache.class)){
                return method.invoke(this.object, args);
            }

            Key k = new Key(method, args);
            if(cache.containsKey(k)){
                return cache.get(k);
            }
            Object o = method.invoke(object,args);
            cache.put(k,o);
            return o;
        }
    }
}

record Key(Method method, Object [] args) {

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Key)) return false;
        Key key = (Key) obj;
        return method.equals(key.method) && Arrays.deepEquals(args, key.args);
    }

    @Override
    public int hashCode() {
        return 31 * method.hashCode() + Arrays.deepHashCode(args);
    }
}
