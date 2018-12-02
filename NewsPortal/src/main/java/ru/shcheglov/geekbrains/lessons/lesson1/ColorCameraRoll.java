package ru.shcheglov.geekbrains.lessons.lesson1;

import org.springframework.stereotype.Component;

/**
 * @author Alexey Shcheglov
 * @version dated 02.12.2018
 */

@Component("cameraRoll")
public class ColorCameraRoll implements CameraRoll {

    public void processing() {
        System.out.println("-1 цветной кадр");
    }
}
