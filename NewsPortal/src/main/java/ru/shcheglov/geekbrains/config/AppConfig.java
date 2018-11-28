package ru.shcheglov.geekbrains.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.shcheglov.geekbrains.entity.Bullet;
import ru.shcheglov.geekbrains.entity.BulletImpl;
import ru.shcheglov.geekbrains.entity.Rifle;
import ru.shcheglov.geekbrains.entity.RifleImpl;

@Configuration
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
