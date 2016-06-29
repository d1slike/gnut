package ru.disdev.model.users;

import ru.disdev.model.privileges.PrivilegeType;

import java.time.LocalDateTime;
import java.util.Date;

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
    Date getRegisteredDate();
    int getRating();

}
