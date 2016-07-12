package ru.disdev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.disdev.model.templates.TaskTemplate;
import ru.disdev.repository.TaskTemplateRepository;

/**
 * Created by Dislike on 12.07.2016.
 */
@Service
public class TaskTemplateServiceImpl implements TaskTemplateService {

    @Autowired
    private TaskTemplateRepository taskTemplateRepository;

    @Override
    public void addNewTemplate(TaskTemplate info) {
        taskTemplateRepository.save(info);
    }
}
