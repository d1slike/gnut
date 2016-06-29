package ru.disdev.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;

import javax.annotation.PostConstruct;

/**
 * Created by Dislike on 29.06.2016.
 */
@SpringView
public class MainView implements View {

    @PostConstruct
    private void init() {

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
