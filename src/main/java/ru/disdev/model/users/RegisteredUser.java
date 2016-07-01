package ru.disdev.model.users;

import ru.disdev.model.privileges.PrivilegeType;
import ru.disdev.model.privileges.UserRole;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Dislike on 28.06.2016.
 */
@Entity
@Table(name = "users")
public class RegisteredUser implements User {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false, length = 20)
    private String login;
    @Column(nullable = false, length = 20)
    private String password;
    private String email;
    private int messageCount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredTime;
    private int rating;
    private UserRole role;

    public RegisteredUser() {

    }

    public RegisteredUser(String login, String password, String email) {
        setLogin(login);
        setPassword(password);
        setEmail(email);
        setPrivilege(UserRole.AUTHORIZED);
        setRegisteredTime(new Date());
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
        switch (role) {
            case ANON:
                return PrivilegeType.ANON_USER_PRIVILEGE;
            case AUTHORIZED:
                return PrivilegeType.AUTHORIZED_USER_PRIVILEGE;
            case ADMIN:
                return PrivilegeType.ADMIN_PRIVILEGE;
            default:
                return PrivilegeType.ANON_USER_PRIVILEGE;
        }
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
    public Date getRegisteredDate() {
        return registeredTime;
    }

    @Override
    public int getRating() {
        return rating;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMessageCount(int messageCount) {
        this.messageCount = messageCount;
    }

    public void setRegisteredTime(Date registeredTime) {
        this.registeredTime = registeredTime;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setPrivilege(UserRole userRole) {
        this.role = userRole;
    }

    @Override
    public String toString() {
        return String.format("login - %s, email - %s, raring - %d, priv - %s",
                login,
                email,
                rating,
                role);
    }
}
