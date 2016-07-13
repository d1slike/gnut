package ru.disdev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.disdev.util.WebPaths;

/**
 * Created by DisDev on 30.06.2016.
 */
@Controller
public class MainController {

    @RequestMapping(value = {"/", "/index"})
    private String loadPage(Model model) {
        return WebPaths.INDEX;
    }

}
