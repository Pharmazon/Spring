package ru.shcheglov.geekbrains.hw.hw2.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.shcheglov.geekbrains.hw.hw2.components.Camera;

/**
 * @author Alexey Shcheglov
 * @version dated 01.12.2018
 */

@Component
public class CameraBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
        if (bean instanceof Camera){
            System.out.println("Делаю пробное фото!");
            ((Camera) bean).doPhotograph();
            System.out.println("Отлично! Работает!");
        }
        return bean;
    }
}
