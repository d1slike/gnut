package ru.disdev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by DisDev on 30.06.2016.
 */
@Controller
public class MainController {

    @RequestMapping(value = {"/", "/index"})
    private String loadPage(Model model) {
        model.addAttribute("greeting", "Hello!");
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("currentTime", formattedDate);
        return "hello";
    }

}
