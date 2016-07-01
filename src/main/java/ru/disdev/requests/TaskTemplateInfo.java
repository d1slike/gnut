package ru.disdev.requests;

import java.util.List;

/**
 * Created by Dislike on 01.07.2016.
 */
public class TaskTemplateInfo {
    private String name;
    private List<TaskTemplateFieldInfo> fields;

    public TaskTemplateInfo(List<TaskTemplateFieldInfo> list) {
        fields = list;
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
