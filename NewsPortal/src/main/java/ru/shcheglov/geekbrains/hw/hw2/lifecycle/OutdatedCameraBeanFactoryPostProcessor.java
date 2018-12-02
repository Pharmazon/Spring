package ru.shcheglov.geekbrains.hw.hw2.lifecycle;

import com.sun.istack.internal.NotNull;
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

    public void postProcessBeanFactory(@NotNull final ConfigurableListableBeanFactory beanFactory) throws BeansException {

        final String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {

            final BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            final String className = beanDefinition.getBeanClassName();

            try {
                final Class<?> beanClass = Class.forName(className);
                final OutdatedCamera annotation = beanClass.getAnnotation(OutdatedCamera.class);
                if (annotation != null) {
                    final Class usingCameraName = annotation.usingCameraClass();
                    beanDefinition.setBeanClassName(usingCameraName.getName());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
