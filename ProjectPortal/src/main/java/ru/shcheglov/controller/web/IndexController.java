package ru.shcheglov.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.shcheglov.model.user.UserProfile;
import ru.shcheglov.repository.user.UserProfileRepository;
import ru.shcheglov.service.user.AuthService;

import java.security.Principal;

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
