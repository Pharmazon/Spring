package ru.shcheglov.geekbrains.hw.hw2.components;

import org.springframework.stereotype.Component;
import ru.shcheglov.geekbrains.hw.hw2.annotation.UnproducableCameraRoll;

/**
 * @author Alexey Shcheglov
 * @version dated 01.12.2018
 */

@Component("cameraRoll")
@UnproducableCameraRoll(usingCameraRollClass = BlackAndWhiteCameraRoll.class)
public class ColorCameraRoll implements CameraRoll {

    public void processing() {
        System.out.println("-1 цветной кадр");
    }
}
