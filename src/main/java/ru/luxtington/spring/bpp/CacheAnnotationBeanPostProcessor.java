package ru.luxtington.spring.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;
import ru.luxtington.annotations.Cache;
import ru.luxtington.annotations.Mutator;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class CacheAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        boolean needsProxy = Arrays.stream(bean.getClass().getDeclaredMethods())
                .anyMatch(m -> m.isAnnotationPresent(Cache.class) || m.isAnnotationPresent(Mutator.class));

        if (needsProxy) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(bean.getClass());
            enhancer.setCallback(new MyCglibCacheInterceptor(bean));
            return enhancer.create();
        }
        return bean;
    }

    private static class MyCglibCacheInterceptor implements MethodInterceptor {
        private final Object target;
        private final Map<Key, Object> cache = new HashMap<>();

        public MyCglibCacheInterceptor(Object target) {
            this.target = target;
        }

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            Method targetMethod = target.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());

            if (targetMethod.isAnnotationPresent(Mutator.class)) {
                cache.clear();
            }

            if (!targetMethod.isAnnotationPresent(Cache.class)) {
                return proxy.invoke(target, args);
            }

            Key k = new Key(targetMethod, args);
            if (cache.containsKey(k)) {
                return cache.get(k);
            }
            Object result = proxy.invoke(target, args);
            cache.put(k, result);
            return result;
        }
    }

    private static record Key(Method method, Object[] args) {
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
}
