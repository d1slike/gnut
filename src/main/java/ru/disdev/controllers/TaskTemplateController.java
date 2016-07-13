package ru.disdev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
public class TaskTemplateController extends AbstractController {

    @Autowired
    private TaskTemplateFieldValidator validator;

    @Autowired
    private TaskTemplateService taskTemplateService;

    @ModelAttribute("fieldTypes")
    public TaskTemplateFieldType[] messages() {
        return TaskTemplateFieldType.values();
    }

    @ModelAttribute("templateList")
    public List<TaskTemplate> templateList() {
        return taskTemplateService.getAll();
    }

    @RequestMapping(params = "addField")
    private String addField(TaskTemplate taskTemplateInfo, Model model) {
        taskTemplateInfo.getFields().add(new TaskTemplateField());
        return WebPaths.TASK_TEMPLATE_EDIT;
    }

    @RequestMapping(path = "/new")
    private ModelAndView newTemplatePage() {
        TaskTemplate templateInfo = new TaskTemplate();
        templateInfo.getFields().add(new TaskTemplateField());
        return new ModelAndView(WebPaths.TASK_TEMPLATE_EDIT, "taskTemplate", templateInfo);
    }

    @RequestMapping(method = RequestMethod.GET)
    private String templateListPage() {
        return WebPaths.TASK_TEMPLATE_LIST;
    }

    @RequestMapping(params = "removeTemplate")
    private String removeTemplate(HttpServletRequest request) {
        int templateId = Integer.parseInt(request.getParameter("removeTemplate"));
        taskTemplateService.deleteById(templateId);
        return makeRedirectTo("template");
    }

    @RequestMapping(path = "edit/{templateId}")
    private ModelAndView editTemplatePage(@PathVariable int templateId, Model model) {
        TaskTemplate taskTemplate = taskTemplateService.getById(templateId);
        if (taskTemplate != null)
            return new ModelAndView(WebPaths.TASK_TEMPLATE_EDIT, "taskTemplate", taskTemplate);
        return new ModelAndView(WebPaths.TASK_TEMPLATE_LIST);
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

        taskTemplateService.saveTemplate(taskTemplateInfo);

        return makeRedirectTo("template");
    }

}
