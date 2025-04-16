package ru.luxtington.spring.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;
import ru.luxtington.spring.beans.RandBean;

import java.util.Random;

@Component
public class RandBeanFactoryPostProcessor implements BeanFactoryPostProcessor {



    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        if (!beanFactory.containsBean("randBean")) {
            System.out.println("Factory is working");
            //beanFactory.registerSingleton("randBean", new RandBean(0, 100)); v1
            BeanDefinition beanDefinition = new RootBeanDefinition(RandBean.class);
            beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);
            beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, 0);
            beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(1, 100);
            ((DefaultListableBeanFactory) beanFactory)
                    .registerBeanDefinition("randBean", beanDefinition);
        }
    }
}
