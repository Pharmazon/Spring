package ru.geekbrains.lessons.lesson2.components;

import org.springframework.stereotype.Component;

/**
 * @author Alexey Shcheglov
 * @version dated 01.12.2018
 */

public class ColorCameraRoll implements CameraRoll {

    public void processing() {
        System.out.println("-1 цветной кадр");
    }
}
