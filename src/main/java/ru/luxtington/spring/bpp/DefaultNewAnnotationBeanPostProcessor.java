package ru.luxtington.spring.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import ru.luxtington.annotations.DefaultNew;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Component
public class DefaultNewAnnotationBeanPostProcessor implements BeanPostProcessor {

    private final ApplicationContext ctx;

    @Autowired
    public DefaultNewAnnotationBeanPostProcessor(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(DefaultNew.class)){

            Object holder = ctx.getBean(bean.getClass().getAnnotation(DefaultNew.class).value());
            for (Field f : bean.getClass().getDeclaredFields()){
                ReflectionUtils.makeAccessible(f);

                if (f.isAnnotationPresent(DefaultNew.class)){
                    ReflectionUtils.setField(f, bean, ctx.getBean(f.getAnnotation(DefaultNew.class).value()));
                    continue;
                }
                for (Method m : holder.getClass().getDeclaredMethods()){
                    if (f.getType() == m.getReturnType()){
                        ReflectionUtils.makeAccessible(m);
                        ReflectionUtils.setField(f, bean, ReflectionUtils.invokeMethod(m, holder));
                        break;
                    }
                }
            }
        }
        return bean;
    }
}
