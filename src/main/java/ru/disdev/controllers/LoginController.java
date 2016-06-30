package ru.disdev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dislike on 30.06.2016.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    private String loginPage() {
        return "login";
    }

    @RequestMapping("/login/error")
    private String ifError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
