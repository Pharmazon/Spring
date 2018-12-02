package ru.geekbrains.lessons.lesson2.components;

/**
 * @author Alexey Shcheglov
 * @version dated 01.12.2018
 */

public interface Camera {

    CameraRoll getCameraRoll();
    void setCameraRoll(CameraRoll cameraRoll);
    void doPhotograph();
    void breaking();
    boolean isBroken();
    void ready();
}
