package ru.disdev.util;

import org.springframework.stereotype.Component;
import ru.disdev.model.templates.TaskTemplateField;

/**
 * Created by Dislike on 12.07.2016.
 */
@Component
public class TaskTemplateFieldValidatorImpl implements TaskTemplateFieldValidator {
    @Override
    public String validate(TaskTemplateField info) {
        if (info == null)
            return "null";
        if (!Constants.NAME_PATTERN.matcher(info.getName()).matches())
            return "Неверный формат имени.";
        return null;
    }
}
