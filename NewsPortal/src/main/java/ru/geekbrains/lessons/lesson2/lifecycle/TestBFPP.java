package ru.geekbrains.lessons.lesson2.lifecycle;

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

        //получение имен  BeanDefinition	 всех бинов, объявленных пользователем
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

        //перебор массива для получения доступа к каждому имени
        for(String name: beanDefinitionNames){

            //получение BeanDefinition по имени(по другом никак!)
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);

            //Вывод информации о BeanDefinition
            System.out.println(beanDefinition.toString());
        }
    }
}