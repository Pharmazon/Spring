package ru.shcheglov.geekbrains.lessons.lesson2.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.shcheglov.geekbrains.lessons.lesson2.components.Camera;

/**
 * @author Alexey Shcheglov
 * @version dated 01.12.2018
 */

@Component
public class PhotocameraTestBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        //в данном методе просто возвращаем бин
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        //находим бин класса фотокамеры
        if (bean instanceof Camera){

            System.out.println("Делаю пробное фото!");
            //делаем пробное фото
            ((Camera) bean).doPhotograph();
            System.out.println("Отлично! Работает!");
        }
        return bean;
    }
}
