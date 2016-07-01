package ru.disdev.requests;

import ru.disdev.util.Constants;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dislike on 01.07.2016.
 */
public class TaskTemplateInfo {

    @Pattern(regexp = Constants.NAME_PATTERN, "Неверный формат имени")
    private String name;
    @Valid
    private List<TaskTemplateFieldInfo> fields = new ArrayList<>();

    public TaskTemplateInfo() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskTemplateFieldInfo> getFields() {
        return fields;
    }

    public void setFields(List<TaskTemplateFieldInfo> fields) {
        this.fields = fields;
    }
}
