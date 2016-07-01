package ru.disdev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.disdev.requests.TaskTemplateFieldInfo;
import ru.disdev.requests.TaskTemplateInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dislike on 01.07.2016.
 */
@Controller
@RequestMapping("/template")
public class TaskTemplateController {
    @RequestMapping(params = "addField")
    private String addField(TaskTemplateInfo taskTemplateInfo, Model model) {
        TaskTemplateFieldInfo info = new TaskTemplateFieldInfo();
        taskTemplateInfo.getFields().add(info);
        return "taskTemplate/create";
    }

    @RequestMapping(method = RequestMethod.GET)
    private String templateEditPage(Model model) {
        TaskTemplateInfo templateInfo = new TaskTemplateInfo();
        templateInfo.getFields().add(new TaskTemplateFieldInfo());
        model.addAttribute(templateInfo);
        return "taskTemplate/create";
    }

    @RequestMapping(params = "removeField")
    private String removeField(TaskTemplateInfo taskTemplateInfo, HttpServletRequest request, Model model) {
        int number = Integer.parseInt(request.getParameter("removeField"));
        taskTemplateInfo.getFields().remove(number);
        return "taskTemplate/create";
    }

}
