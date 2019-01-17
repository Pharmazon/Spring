package ru.shcheglov.spring.second.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Alexey Shcheglov
 * @version dated 16.01.2019
 */

@Controller
public class IndexController {

    @GetMapping("/")
    public String hello() {
        return "index";
    }
}
