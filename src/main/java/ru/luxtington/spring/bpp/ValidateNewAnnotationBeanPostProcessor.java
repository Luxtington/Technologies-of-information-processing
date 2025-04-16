package ru.luxtington.spring.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import ru.luxtington.annotations.ValidateNew;
import ru.luxtington.reflection.base.testSystem.TestValidationException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ValidateNewAnnotationBeanPostProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    @Autowired
    public ValidateNewAnnotationBeanPostProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String beanName) throws BeansException {
        if (!(o.getClass().isAnnotationPresent(ValidateNew.class))){
            //System.out.println("Warning: Object of type " + o.getClass().getSimpleName()
             //       + " isn't ready for testing, it hasn't pinned classes for tests");
            return o;
        }
        Object testClass;
        if (o.getClass().isAnnotationPresent(ValidateNew.class)) {
            testClass = applicationContext.getBean(o.getClass().getAnnotation(ValidateNew.class).value());
        } else {
            Annotation an = Arrays.stream(o.getClass().getAnnotations())
                    .filter(annotation -> annotation.annotationType().isAnnotationPresent(ValidateNew.class))
                    .findFirst().orElse(null); // по сути null никогда не будет
            testClass = an.annotationType().getAnnotation(ValidateNew.class).value();
        }

        Map<Method, Throwable> objectLogs = new HashMap<>();

            Constructor<?> constructor = testClass.getClass().getDeclaredConstructors()[0];

            for (Method m : testClass.getClass().getDeclaredMethods()) {
                try {
                    m.setAccessible(true);
                    m.invoke(constructor.newInstance(o));
                    m.setAccessible(false);
                } catch (Exception e) {
                    objectLogs.put(m, e.getCause());
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
        return o;
    }
}
