package ru.shcheglov.geekbrains.hw.hw1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.shcheglov.geekbrains.hw.hw1.component.Bullet;
import ru.shcheglov.geekbrains.hw.hw1.component.BulletImpl;
import ru.shcheglov.geekbrains.hw.hw1.component.Rifle;
import ru.shcheglov.geekbrains.hw.hw1.component.RifleImpl;

/**
 * @author Alexey Shcheglov
 * @version dated 29.11.2018
 */

@Configuration
@ComponentScan("ru.shcheglov.geekbrains.hw.hw1.component")
public class AppConfig {

    @Bean(name = "bullet")
    public Bullet bullet() {
        return new BulletImpl();
    }

    @Bean(name = "rifle")
    public Rifle rifle(Bullet bullet) {
        Rifle rifle = new RifleImpl();
        rifle.setBullet(bullet);
        return rifle;
    }
}
