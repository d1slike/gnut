package ru.disdev.model.templates;

import ru.disdev.model.templates.validation.FieldValidator;

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
    private FieldValidator validator;

    TaskTemplateField() {

    }

    public TaskTemplateField(TaskTemplateFieldType taskTemplateFieldType, String name, FieldValidator validator) {
        this.type = taskTemplateFieldType;
        this.name = name;
        this.validator = validator;
    }

    public String getName() {
        return name;
    }

    public FieldValidator getValidator() {
        return validator;
    }

    public TaskTemplateFieldType getType() {
        return type;
    }
}
