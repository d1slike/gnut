package ru.disdev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.disdev.requests.TaskTemplateFieldInfo;
import ru.disdev.requests.TaskTemplateInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dislike on 01.07.2016.
 */
@Controller
@RequestMapping("/template")
public class TaskTemplateController {
    @RequestMapping(method = RequestMethod.POST, params = "addField")
    private Model addField(List<TaskTemplateFieldInfo> list, Model model) {
        list.add(new TaskTemplateFieldInfo());
        return model;
    }

    @RequestMapping(method = RequestMethod.GET)
    private String templateEditPage(Model model) {
        List<TaskTemplateFieldInfo> infoList = new ArrayList<>();
        infoList.add(new TaskTemplateFieldInfo());
        model.addAttribute("list", infoList);
        model.addAttribute("template", new TaskTemplateInfo(infoList));
        return "taskTemplates/create";
    }

}
