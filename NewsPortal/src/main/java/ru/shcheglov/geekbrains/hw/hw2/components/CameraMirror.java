package ru.shcheglov.geekbrains.hw.hw2.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.shcheglov.geekbrains.hw.hw2.annotation.OutdatedCamera;

import javax.annotation.PostConstruct;

/**
 * @author Alexey Shcheglov
 * @version dated 01.12.2018
 */

@Component("camera")
@OutdatedCamera(usingCameraClass = CameraMirrorLess.class)
@Scope("prototype")
public class CameraMirror implements Camera {

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

    public boolean isBroken() {
        return broken;
    }

    public void breaking(){
        this.broken = true;
    }

    public boolean isOutdated() {
        return outdated;
    }

    public void outdating() {
        this.outdated = true;
    }

    public void doPhotograph() {
        if (isOutdated()) {
            System.out.println("Зеркальный фотоаппарат устарел!");
            return;
        }
        if (isBroken()) {
            System.out.println("Зеркальный фотоаппарат сломан!");
            return;
        }
        System.out.println("Сделана фотография на зеркальный фотоаппарат!");
        cameraRoll.processing();
    }

    @PostConstruct
    public void ready() {
        System.out.println("Зеркальный фотоаппарат готов к использованию!");
    }
}
