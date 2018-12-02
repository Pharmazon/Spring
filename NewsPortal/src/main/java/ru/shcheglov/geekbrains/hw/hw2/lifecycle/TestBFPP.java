package ru.shcheglov.geekbrains.hw.hw2.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author Alexey Shcheglov
 * @version dated 01.12.2018
 */

@Component
public class TestBFPP implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String name: beanDefinitionNames){
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            System.out.println(beanDefinition.toString());
        }
    }
}