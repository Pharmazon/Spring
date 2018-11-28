package ru.shcheglov.geekbrains;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("ru.shcheglov.geekbrains")
public class AppConfig {

    @Bean(name = "bullet")
    public Bullet bullet() {
        return new BulletImpl();
    }

    @Bean(name = "rifle")
    public Rifle rifle(Bullet bullet) {
        Rifle rifle = (Rifle) new RifleImpl();
        rifle.setBullet(bullet);
        return rifle;
    }
}
