package ru.disdev.model.users;

import ru.disdev.model.privileges.PrivilegeType;

import java.time.LocalDateTime;

/**
 * Created by Dislike on 28.06.2016.
 */
public interface User {
    int getId();
    String getLogin();
    String getPassword();
    PrivilegeType getPrivilege();
    String getEmail();
    int getMessageCount();
    LocalDateTime getRegisteredDate();
    int getRating();

}
