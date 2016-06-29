package ru.disdev.services;

import ru.disdev.model.users.RegisteredUser;
import ru.disdev.model.users.User;

import java.util.Collection;

/**
 * Created by Dislike on 29.06.2016.
 */
public interface UserService {
    User getById(int id);
    User getByLogin(String login);
    Collection<RegisteredUser> getAll();
    void deleteByLogin(String login);
    void deleteById(int id);
    void save(RegisteredUser user);
    void update(RegisteredUser user);
}
