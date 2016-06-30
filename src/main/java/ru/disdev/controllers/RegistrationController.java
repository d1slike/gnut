package ru.disdev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.disdev.model.users.RegisteredUser;
import ru.disdev.requests.RegistrationInfo;
import ru.disdev.services.UserService;

/**
 * Created by Dislike on 30.06.2016.
 */
@Controller
public class RegistrationController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    private String registrationPage(Model model) {
        model.addAttribute("registrationInfo", new RegistrationInfo());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    private String registrationPage(
            @ModelAttribute
                    RegistrationInfo info,
            Model model) {
        service.save(new RegisteredUser(info.getLogin(), info.getPassword(), info.getEmail()));
        model.addAttribute("registeredSuccess", true);
        return "login";
    }
}
