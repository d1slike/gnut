package ru.disdev.util;

import java.util.regex.Pattern;

/**
 * Created by Dislike on 01.07.2016.
 */
public class Constants {
    public static final String NAME_PATTERN_STRING = "^[a-zA-Z0-9]+$";
    public static final Pattern NAME_PATTERN = Pattern.compile(NAME_PATTERN_STRING);
}
