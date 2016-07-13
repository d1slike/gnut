package ru.disdev.controllers;

/**
 * Created by Dislike on 13.07.2016.
 */
public abstract class AbstractController {
    protected final String makeRedirectTo(String webPath) {
        return "redirect:" + webPath;
    }
}
