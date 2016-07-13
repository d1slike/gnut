package ru.disdev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.disdev.model.templates.TaskTemplate;
import ru.disdev.repository.TaskTemplateRepository;

import java.util.List;

/**
 * Created by Dislike on 12.07.2016.
 */
@Service
public class TaskTemplateServiceImpl implements TaskTemplateService {

    @Autowired
    private TaskTemplateRepository taskTemplateRepository;

    @Override
    public void saveTemplate(TaskTemplate info) {
        taskTemplateRepository.save(info);
    }

    @Override
    public TaskTemplate getById(int id) {
        return taskTemplateRepository.findOne(id);
    }

    @Override
    public List<TaskTemplate> getAll() {
        return taskTemplateRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        taskTemplateRepository.delete(id);
    }
}
