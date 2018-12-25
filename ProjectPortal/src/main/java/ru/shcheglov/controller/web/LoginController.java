package ru.shcheglov.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.shcheglov.model.user.User;
import ru.shcheglov.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Alexey Shcheglov
 * @version dated 24.12.2018
 */

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    private String login() {
        return "login";
    }

    @RequestMapping(value = "/loginAction", method = RequestMethod.POST)
    public String loginProcess(
            final HttpServletRequest request,
            @ModelAttribute("login") final String login,
            @ModelAttribute("password") final String password,
            final BindingResult result) {

        if (login == null || password == null) return "redirect:/login";
        if (login.isEmpty() || password.isEmpty()) return "redirect:/login";

        final User user = userService.getByLogin(login);
        if (user == null) return "redirect:/login";

        final boolean passwordCorrect = passwordEncoder.matches(password, user.getPassword());
        if (!passwordCorrect) return "redirect:/login";

        if (!result.hasErrors()) {
            final HttpSession session = request.getSession();
            session.setAttribute("auth", true);
            session.setAttribute("userId", user.getId());
        }

        return "redirect:/profile/profile-view";
    }

    @GetMapping("/logout")
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        final HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/login";
    }

}
