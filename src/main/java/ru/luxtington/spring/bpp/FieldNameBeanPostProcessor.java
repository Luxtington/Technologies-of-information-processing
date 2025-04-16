package ru.luxtington.spring.bpp;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;

@Component
public class FieldNameBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, @NotNull String beanName) throws BeansException {

        if (bean.getClass().getName().startsWith("java.") || bean.getClass().getName().startsWith("javax.")) {
            return bean;
        }

        List<Field> fields = List.of(bean.getClass().getDeclaredFields());

        for (Field f : fields){
            ReflectionUtils.makeAccessible(f);
            if (f.getName().equals("name") && f.getType().equals(String.class)
                    && ReflectionUtils.getField(f, bean) == null ){
                ReflectionUtils.setField(f, bean, "vasia");
            }
        }
        return bean;
    }
}
