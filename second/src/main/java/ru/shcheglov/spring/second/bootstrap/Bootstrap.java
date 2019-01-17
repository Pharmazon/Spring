package ru.shcheglov.spring.second.bootstrap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.shcheglov.spring.second.service.PersonService;

/**
 * @author Alexey Shcheglov
 * @version dated 18.01.2019
 */

@Component
public class Bootstrap implements InitializingBean {

    @Autowired
    private PersonService personService;

    @Override
    public void afterPropertiesSet() throws Exception {
        personService.initPerson("Иван", "Иванов", "Иванович", "ivan@ivanov.ru");
        personService.initPerson("Петр", "Петров", "Петрович", "petr@petrov.ru");
        personService.initPerson("Сидр", "Сидоров", "Сидорович", "sidr@sidorov.ru");
    }

}
