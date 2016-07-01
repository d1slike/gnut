package ru.disdev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.disdev.model.users.RegisteredUser;
import ru.disdev.requests.RegistrationInfo;
import ru.disdev.services.UserService;

import javax.validation.Valid;

/**
 * Created by Dislike on 30.06.2016.
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    private String registrationPage(Model model) {

        model.addAttribute("registrationInfo", new RegistrationInfo());
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    private String registrationPage(
            @Valid
                    RegistrationInfo info,
            BindingResult result,
            Model model
    ) {

        boolean success = true;

        if (result.hasErrors()) {
            success = false;
        }
        if (service.checkForExistsByLogin(info.getLogin())) {
            model.addAttribute("loginAlreadyExist", true);
            success = false;
        }
        if (service.checkForExistByEmail(info.getEmail())) {
            model.addAttribute("emailAlreadyExist", true);
            success = false;
        }

        if (!success) {
            model.addAttribute("registrationInfo", info);
            return "/registration";
        }

        service.save(new RegisteredUser(info.getLogin(), info.getPassword(), info.getEmail()));
        model.addAttribute("registeredSuccess", true);
        return "login";
    }
}
