package ru.shcheglov.geekbrains.lessons.lesson2.components;

import org.springframework.stereotype.Component;
import ru.shcheglov.geekbrains.lessons.lesson2.annotation.UnproducableCameraRoll;

/**
 * @author Alexey Shcheglov
 * @version dated 01.12.2018
 */

@Component("cameraRoll")
@UnproducableCameraRoll(usingCameraRollClass = ColorCameraRoll.class)
public class BlackAndWhiteCameraRoll implements CameraRoll {

    public void processing(){
        System.out.println("-1 черно-белый кадр");
    }
}
