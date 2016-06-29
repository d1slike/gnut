package ru.disdev.view;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import ru.disdev.model.users.RegisteredUser;
import ru.disdev.repository.UserRepository;

/**
 * Created by DisDev on 29.06.2016.
 */
@SpringUI
@Theme("valo")
public class MainPage extends UI {

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Grid grid = new Grid();
        grid.setContainerDataSource(new BeanItemContainer<>(RegisteredUser.class,
                userRepository.findAll()));
        setContent(grid);
    }
}
