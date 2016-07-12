package ru.disdev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.disdev.model.templates.TaskTemplate;
import ru.disdev.model.templates.TaskTemplateField;
import ru.disdev.model.templates.TaskTemplateFieldType;
import ru.disdev.services.TaskTemplateService;
import ru.disdev.util.TaskTemplateFieldValidator;
import ru.disdev.util.WebPaths;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Dislike on 01.07.2016.
 */
@Controller
@RequestMapping("/template")
public class TaskTemplateController {

    @Autowired
    private TaskTemplateFieldValidator validator;

    @Autowired
    private TaskTemplateService taskTemplateService;

    @ModelAttribute("fieldTypes")
    public TaskTemplateFieldType[] messages() {
        return TaskTemplateFieldType.values();
    }

    @RequestMapping(params = "addField")
    private String addField(TaskTemplate taskTemplateInfo, Model model) {
        taskTemplateInfo.getFields().add(new TaskTemplateField());
        return WebPaths.TASK_TEMPLATE_EDIT;
    }

    @RequestMapping(method = RequestMethod.GET)
    private String templateEditPage(Model model) {
        TaskTemplate templateInfo = new TaskTemplate();
        templateInfo.getFields().add(new TaskTemplateField());
        model.addAttribute(templateInfo);
        return WebPaths.TASK_TEMPLATE_EDIT;
    }

    @RequestMapping(params = "removeField")
    private String removeField(TaskTemplate taskTemplateInfo, HttpServletRequest request, Model model) {
        int number = Integer.parseInt(request.getParameter("removeField"));
        taskTemplateInfo.getFields().remove(number);
        return WebPaths.TASK_TEMPLATE_EDIT;
    }

    @RequestMapping(params = "save")
    private String saveTemplate(@Valid TaskTemplate taskTemplateInfo, BindingResult bindingResult, Model model) {
        boolean success = !bindingResult.hasErrors();

        if (success) {
            List<TaskTemplateField> infoList = taskTemplateInfo.getFields();
            for (int i = 0; i < infoList.size(); i++) {
                String error = validator.validate(infoList.get(i));
                if (error != null) {
                    model.addAttribute("error" + i, error);
                    success = false;
                }

            }
        }

        if (!success)
            return WebPaths.TASK_TEMPLATE_EDIT;

        taskTemplateService.addNewTemplate(taskTemplateInfo);

        return "redirect:index";
    }

}
