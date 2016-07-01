package ru.disdev.model.templates;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Dislike on 01.07.2016.
 */
@Entity
public class TaskTemplate {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ElementCollection
    @CollectionTable(name = "template_fields", joinColumns = @JoinColumn(name = "task_template_id"))
    private List<TaskTemplateField> fields;

    public TaskTemplate(String name, List<TaskTemplateField> fields) {
        this.name = name;
        this.fields = fields;
    }

    public String getName() {
        return name;
    }

    public List<TaskTemplateField> getFields() {
        return fields;
    }

    public int getId() {
        return id;
    }
}
