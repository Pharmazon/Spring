package ru.shcheglov.geekbrains.hw.hw2.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import ru.shcheglov.geekbrains.hw.hw2.annotation.OutdatedCamera;

/**
 * @author Alexey Shcheglov
 * @version dated 02.12.2018
 */

@Component
public class OutdatedCameraBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {

            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            String className = beanDefinition.getBeanClassName();

            try {
                Class<?> beanClass = Class.forName(className);
                OutdatedCamera annotation = beanClass.getAnnotation(OutdatedCamera.class);
                if (annotation != null) {
                    Class usingCameraName = annotation.usingCameraClass();
                    beanDefinition.setBeanClassName(usingCameraName.getName());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
