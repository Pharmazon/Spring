package ru.shcheglov.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.shcheglov.service.CompanyService;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Controller
public class UserController {

    @Autowired
    private CompanyService companyService;
}
