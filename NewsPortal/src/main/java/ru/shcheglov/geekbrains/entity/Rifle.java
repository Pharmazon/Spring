package ru.shcheglov.geekbrains.entity;

public interface Rifle {
    void shoot();
    void setBullet(Bullet bullet);
    Bullet getBullet();
}
