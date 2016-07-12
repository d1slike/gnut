package ru.disdev.services;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.disdev.model.users.RegisteredUser;
import ru.disdev.model.users.User;
import ru.disdev.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dislike on 29.06.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository repository;

    private Map<Integer, RegisteredUser> users = new ConcurrentHashMap<>();

    @PostConstruct
    private void init() {
        repository.findAll().forEach(registeredUser -> users.put(registeredUser.getId(), registeredUser));
        LOGGER.info("Was loaded " + users.size() + " users.");
    }

    @Override
    public User getById(int id) {
        return users.getOrDefault(id, null);
    }

    @Override
    public User getByLogin(String login) {
        for (User user : users.values())
            if (user.getLogin().equals(login))
                return user;
        return null;
    }

    @Override
    public Collection<RegisteredUser> getAll() {
        return users.values();
    }

    @Override
    public void deleteByLogin(String login) {
        User user = getByLogin(login);
        if (user != null) {
            final int id = user.getId();
            users.remove(id);
            repository.delete(id);
        }
    }

    @Override
    public void deleteById(int id) {
        User user = getById(id);
        if (user != null) {
            users.remove(id);
            repository.delete(id);
        }
    }

    @Override
    public void save(RegisteredUser user) {
        update(user);
        users.put(user.getId(), user);
    }

    @Override
    public void update(RegisteredUser user) {
        repository.save(user);
    }

    @Override
    public boolean checkForExistsByLogin(String login) {
        return getByLogin(login) != null;
    }

    @Override
    public boolean checkForExistByEmail(String email) {
        for (User user : users.values())
            if (user.getEmail().equals(email))
                return true;
        return false;
    }


}
