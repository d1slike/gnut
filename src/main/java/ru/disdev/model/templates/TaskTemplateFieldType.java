package ru.disdev.model.templates;

/**
 * Created by Dislike on 01.07.2016.
 */
public enum TaskTemplateFieldType {
    TEXT("Однострочный текст"), OPTIONAL_TEXT("Многострочный текст"), IMAGE("Картинка");

    private String description;

    TaskTemplateFieldType() {

    }

    TaskTemplateFieldType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
