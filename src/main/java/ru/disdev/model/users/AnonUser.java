package ru.disdev.model.users;

import ru.disdev.model.privileges.PrivilegeType;

import java.time.LocalDateTime;

/**
 * Created by Dislike on 28.06.2016.
 */
public final class AnonUser implements User {
    @Override
    public int getId() {
        return -1;
    }

    @Override
    public String getLogin() {
        return "anon";
    }

    @Override
    public String getPassword() {
        return "anon";
    }

    @Override
    public PrivilegeType getPrivilege() {
        return PrivilegeType.ANON_USER_PRIVILEGE;
    }

    @Override
    public String getEmail() {
        return "anon";
    }

    @Override
    public int getMessageCount() {
        return 0;
    }

    @Override
    public LocalDateTime getRegisteredDate() {
        return null;
    }

    @Override
    public int getRating() {
        return 0;
    }
}
