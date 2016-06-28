package ru.disdev.model.users;

import ru.disdev.model.privileges.PrivilegeType;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Dislike on 28.06.2016.
 */
@Entity
@Table(name = "users")
public class RegisteredUser implements User {

    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true)
    private String login;
    private String password;
    private String email;
    private int messageCount;
    private LocalDateTime registeredTime;
    private int rating;
    private PrivilegeType privilege;

    public RegisteredUser() {

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public PrivilegeType getPrivilege() {
        return privilege;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public int getMessageCount() {
        return messageCount;
    }

    @Override
    public LocalDateTime getRegisteredDate() {
        return registeredTime;
    }

    @Override
    public int getRating() {
        return rating;
    }
}
