package ru.disdev.services;

import ru.disdev.model.templates.TaskTemplate;

import java.util.List;

/**
 * Created by Dislike on 12.07.2016.
 */
public interface TaskTemplateService {
    void saveTemplate(TaskTemplate info);
    TaskTemplate getById(int id);
    List<TaskTemplate> getAll();
    void deleteById(int id);

}
