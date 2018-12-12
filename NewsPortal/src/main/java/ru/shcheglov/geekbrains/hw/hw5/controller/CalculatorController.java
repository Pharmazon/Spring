package ru.shcheglov.geekbrains.hw.hw5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Alexey Shcheglov
 * @version dated 12.12.2018
 */

@Controller
public class CalculatorController {

    @GetMapping("/calc")
    public ModelAndView calcGET(
            @RequestParam("a") Double a,
            @RequestParam("b") Double b
    ) {
        return new ModelAndView("calc", "result", a + b);
    }

    @PostMapping("/calc")
    public ModelAndView calcPOST(
            @RequestParam("a") Double a,
            @RequestParam("b") Double b
    ) {
        return new ModelAndView("calc", "result", a + b);
    }

}
