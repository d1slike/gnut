package ru.disdev.requests;

/**
 * Created by Dislike on 01.07.2016.
 */
public class TaskTemplateFieldInfo {
    private String type;
    private String name;
    private String condition;
    private boolean required;

    public TaskTemplateFieldInfo() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}
