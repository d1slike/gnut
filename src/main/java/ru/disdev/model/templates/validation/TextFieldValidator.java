package ru.disdev.model.templates.validation;

/**
 * Created by Dislike on 01.07.2016.
 */
public class TextFieldValidator implements FieldValidator {

    private int minLength;
    private int maxLenght;

    public TextFieldValidator(int minLength, int maxLenght) {
        this.minLength = minLength;
        this.maxLenght = maxLenght;
    }

    @Override
    public boolean check(Object... objects) {
        final int first = (int) objects[0];
        final int second = (int) objects[1];

        return first >= minLength && second <= minLength;
    }
}
