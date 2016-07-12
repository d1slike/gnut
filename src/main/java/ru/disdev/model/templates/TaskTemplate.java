package ru.disdev.model.templates;

import ru.disdev.util.Constants;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dislike on 01.07.2016.
 */
@Entity
public class TaskTemplate {
    @Id
    @GeneratedValue
    private int id;
    @Pattern(regexp = Constants.NAME_PATTERN_STRING, message = "Неверный формат имени")
    private String name;
    @ElementCollection
    @CollectionTable(name = "template_fields", joinColumns = @JoinColumn(name = "task_template_id"))
    private List<TaskTemplateField> fields;

    public TaskTemplate() {
        fields = new ArrayList<>();
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

    public void setFields(List<TaskTemplateField> fields) {
        this.fields = fields;
    }

    public void setName(String name) {
        this.name = name;
    }
}
