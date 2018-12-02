package ru.geekbrains.lessons.lesson2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.geekbrains.lessons.lesson2.components.BlackAndWhiteCameraRoll;
import ru.geekbrains.lessons.lesson2.components.Camera;
import ru.geekbrains.lessons.lesson2.components.CameraImpl;
import ru.geekbrains.lessons.lesson2.components.CameraRoll;

/**
 * @author Alexey Shcheglov
 * @version dated 01.12.2018
 */

@Configuration
@ComponentScan({"ru.geekbrains.lessons.lesson2.components", "ru.geekbrains.lessons.lesson2.lifecycle"})
public class AppConfig {

//    @Bean(name = "camera")
//    public Camera camera(CameraRoll cameraRoll) {
//        Camera camera = new CameraImpl();
//        camera.setCameraRoll(cameraRoll);
//        return camera;
//    }
//
//    @Bean(name = "cameraRoll")
//    public CameraRoll cameraRoll() {
//        return new BlackAndWhiteCameraRoll();
//    }
}
