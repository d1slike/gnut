package ru.disdev.model.templates;

import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Dislike on 01.07.2016.
 */
@Embeddable
@Table(name = "template_fields")
public class TaskTemplateField implements Serializable {

    private TaskTemplateFieldType type;
    private String name;
    private boolean required;

    public TaskTemplateField() {

    }

    public String getName() {
        return name;
    }

    public TaskTemplateFieldType getType() {
        return type;
    }

    public boolean isRequired() {
        return required;
    }

    public void setType(TaskTemplateFieldType type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}
