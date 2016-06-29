package ru.disdev.view;

import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.PostConstruct;

/**
 * Created by Dislike on 29.06.2016.
 */
@SpringUI(path = "/login")
@Title("Авторизация")
public class LoginView extends UI {

    private VerticalLayout layout;

    @Autowired
    AuthenticationManager authenticationManage;

    @PostConstruct
    private void load() {


    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setSizeFull();
        layout = new VerticalLayout();
        TextField loginField = new TextField();
        loginField.setRequired(true);
        PasswordField passwordField = new PasswordField();
        passwordField.setRequired(true);

        HorizontalLayout login = new HorizontalLayout();
        login.addComponents(new Label("Логин"), loginField);

        HorizontalLayout password = new HorizontalLayout();
        password.addComponents(new Label("Пароль"), passwordField);

        Button authButton = new Button("Войти");
        authButton.addClickListener(clickEvent -> {
            try {
                Authentication authentication;
                authentication = authenticationManage.authenticate(new UsernamePasswordAuthenticationToken(
                        loginField.getValue(),
                        passwordField.getValue()
                ));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                getPage().setLocation("/");
            } catch (Exception ex) {
                Notification.show("Login failed.", ex.getMessage(), Notification.Type.ERROR_MESSAGE);
            }

        });

        layout.addComponents(login, password, authButton);
        setContent(layout);
    }
}
