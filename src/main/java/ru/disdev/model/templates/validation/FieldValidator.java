package ru.disdev.model.templates.validation;

import java.io.Serializable;

/**
 * Created by Dislike on 01.07.2016.
 */
public interface FieldValidator extends Serializable {
    boolean check(Object... objects);
}
