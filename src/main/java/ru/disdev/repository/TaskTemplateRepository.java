package ru.disdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.disdev.model.templates.TaskTemplate;

/**
 * Created by Dislike on 01.07.2016.
 */
public interface TaskTemplateRepository extends JpaRepository<TaskTemplate, Integer> {
}
