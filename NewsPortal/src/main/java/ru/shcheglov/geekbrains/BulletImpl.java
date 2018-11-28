package ru.shcheglov.geekbrains;

import org.springframework.stereotype.Component;

@Component("bullet")
public class BulletImpl implements Bullet {

    public void crash() {
        System.out.println("-1 пуля");
    }
}
