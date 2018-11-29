package ru.shcheglov.geekbrains.entity;

import org.springframework.stereotype.Component;

@Component("bullet")
public class BulletImpl implements Bullet {

    public void crash() {
        System.out.println("-1 пуля");
    }
}
