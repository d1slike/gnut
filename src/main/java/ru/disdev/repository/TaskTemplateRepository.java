package ru.disdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.disdev.model.templates.TaskTemplate;

/**
 * Created by Dislike on 01.07.2016.
 */
@Repository
public interface TaskTemplateRepository extends JpaRepository<TaskTemplate, Integer> {
}
