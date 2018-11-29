package ru.shcheglov.geekbrains.entity;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Alexey Shcheglov
 * @version dated 29.11.2018
 */

@Component("rifle")
public class RifleImpl implements Rifle {

    @Autowired
    private Bullet bullet;

    public void shoot() {
        System.out.println("Выстрел!");
        bullet.crash();
    }

    public void setBullet(@NotNull final Bullet bullet) {
        this.bullet = bullet;
    }

    public Bullet getBullet() {
        return bullet;
    }
}
