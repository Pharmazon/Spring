package ru.shcheglov.spring.second;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Alexey Shcheglov
 * @version dated 16.01.2019
 */

@SpringBootApplication(exclude = JpaRepositoriesAutoConfiguration.class)
@EnableAspectJAutoProxy
public class SecondApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondApplication.class, args);
	}

}

