package ru.shcheglov.geekbrains.lessons.lesson1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Alexey Shcheglov
 * @version dated 02.12.2018
 */

@Component("camera")
public class CameraImpl implements Camera {

    @Autowired
    @Qualifier("cameraRoll")
    private CameraRoll cameraRoll;

    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    public void doPhotograph(){
        System.out.println("Сделана фотография!");
        cameraRoll.processing();
    }
}
