package ru.shcheglov.geekbrains.lessons.lesson1;

/**
 * @author Alexey Shcheglov
 * @version dated 02.12.2018
 */

public interface Camera {

    CameraRoll getCameraRoll();
    void setCameraRoll(CameraRoll cameraRoll);
    void doPhotograph();
}
