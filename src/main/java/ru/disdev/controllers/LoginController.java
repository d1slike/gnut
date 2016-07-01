package ru.disdev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dislike on 30.06.2016.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping()
    private String loginPage() {
        return "login";
    }

    @RequestMapping(params = "error")
    private String ifError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
