package ru.shcheglov.geekbrains.hw.hw1.entity;

import org.springframework.stereotype.Component;

/**
 * @author Alexey Shcheglov
 * @version dated 29.11.2018
 */

@Component("bullet")
public class BulletImpl implements Bullet {

    public void crash() {
        System.out.println("-1 пуля");
    }
}
