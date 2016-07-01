package ru.disdev.model.templates.validation;

/**
 * Created by Dislike on 01.07.2016.
 */
public class ImageFieldValidator implements FieldValidator {

    private int maxSizeInBytes;
    private int maxWidth;
    private int maxHeight;

    public ImageFieldValidator(int maxSizeInBytes, int maxWidth, int maxHeight) {
        this.maxSizeInBytes = maxSizeInBytes;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean check(Object... objects) {
        int size = (int) objects[0];
        int width = (int) objects[1];
        int height = (int) objects[2];

        return size <= maxSizeInBytes && width <= maxWidth && height <= maxHeight;
    }
}
