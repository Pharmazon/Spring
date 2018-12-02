package ru.shcheglov.geekbrains.hw.hw2.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

/**
 * @author Alexey Shcheglov
 * @version dated 02.12.2018
 */

public class CameraMirrorLess implements Camera {

    @Autowired
    @Qualifier("cameraRoll")
    private CameraRoll cameraRoll;

    @Value("false")
    private boolean broken;

    @Value("false")
    private boolean outdated;

    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    public void breaking() {
        this.broken = true;
    }

    public boolean isBroken() {
        return broken;
    }

    public boolean isOutdated() {
        return outdated;
    }

    public void outdating() {
        this.outdated = true;
    }

    public void doPhotograph() {
        if (isOutdated()) {
            System.out.println("Беззеркальный фотоаппарат устарел!");
            return;
        }
        if (isBroken()) {
            System.out.println("Беззеркальный фотоаппарат сломан!");
            return;
        }
        System.out.println("Сделана фотография на беззеркальный фотоаппарат!");
        cameraRoll.processing();
    }

    @PostConstruct
    public void ready() {
        System.out.println("Беззеркальный фотоаппарат готов к использованию!");
    }
}
