package ru.disdev;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SpringUI
public class GnutApplication extends UI {

	public static void main(String[] args) {
		SpringApplication.run(GnutApplication.class, args);
	}

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		setContent(new Label("Hello world"));
	}
}
