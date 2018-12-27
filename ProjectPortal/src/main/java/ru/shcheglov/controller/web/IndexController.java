package ru.shcheglov.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Alexey Shcheglov
 * @version dated 24.12.2018
 */

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
