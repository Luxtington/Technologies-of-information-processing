package ru.luxtington.spring.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;
import ru.luxtington.annotations.ToString;
import ru.luxtington.annotations.ToStringOption;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

@Component
public class ToStringAnnotationBeanPostProcessor implements BeanPostProcessor {
    private Set<String> beansWithToString = new HashSet<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (isToStringNecessary(bean))
            beansWithToString.add(beanName);
        return bean;
    }

    private boolean isToStringNecessary(Object bean){
        return bean.getClass().isAnnotationPresent(ToString.class) ||
                Arrays.stream(bean.getClass().getDeclaredFields())
                        .anyMatch(f -> f.isAnnotationPresent(ToString.class));
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return beansWithToString.contains(beanName) ? createToStringProxy(bean) : bean;
    }

    private Object createToStringProxy(Object target) {
        return Enhancer.create(
                target.getClass(),
                new ToStringMethodInterceptor(target));
    }

    private static class ToStringMethodInterceptor implements MethodInterceptor {
        private final Object target;

        public ToStringMethodInterceptor(Object target) {
            this.target = target;
        }

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            if ("toString".equals(method.getName()) && method.getParameterTypes().length == 0) {
                return generateToString(target);
            }
            return proxy.invoke(target, args);
        }

        private String generateToString(Object target) {
            StringBuilder res = new StringBuilder(target.getClass().getSimpleName() + " { ");

            Class<?> currCl = target.getClass();
            while (currCl != null) {
                try {
                    collectFields(target, currCl, res);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                currCl = currCl.getSuperclass();
            }

            if (res.length() > target.getClass().getSimpleName().length() + 3) {
                res.delete(res.length() - 2, res.length());
            }
            res.append(" }");
            return res.toString();
        }

        private void collectFields(Object target, Class<?> cl, StringBuilder sb) throws Exception {
            List<Field> fields = List.of(cl.getDeclaredFields());
            if (!cl.isAnnotationPresent(ToString.class) ||
                    (cl.isAnnotationPresent(ToString.class) &&
                            cl.getAnnotation(ToString.class).value() == ToStringOption.YES)) {

                for (Field f : fields) {
                    f.setAccessible(true);
                    if (!f.isAnnotationPresent(ToString.class) ||
                            (f.isAnnotationPresent(ToString.class) &&
                                    f.getAnnotation(ToString.class).value() == ToStringOption.YES)) {
                        sb.append(f.getName()).append("=").append(f.get(target)).append(", ");
                    }
                    f.setAccessible(false);
                }
            } else {
                for (Field f : fields) {
                    f.setAccessible(true);
                    if (f.isAnnotationPresent(ToString.class) &&
                            f.getAnnotation(ToString.class).value() == ToStringOption.YES) {
                        sb.append(f.getName()).append("=").append(f.get(target)).append(", ");
                    }
                    f.setAccessible(false);
                }
            }
        }
    }
}