package ru.disdev.model.privileges;

/**
 * Created by Dislike on 28.06.2016.
 */
public final class AuthorizedUserPrivilegeType implements PrivilegeType {
    protected AuthorizedUserPrivilegeType() {

    }

    @Override
    public boolean canCreateTask() {
        return true;
    }

    @Override
    public boolean canEditTask() {
        return false;
    }

    @Override
    public boolean canCloseAnyTask() {
        return false;
    }

    @Override
    public boolean canAddMessage() {
        return true;
    }

    @Override
    public boolean canEditMessage() {
        return false;
    }

    @Override
    public boolean canDeleteMessage() {
        return false;
    }

    @Override
    public boolean canEditHisInformation() {
        return true;
    }

    @Override
    public boolean canEditAnyUser() {
        return false;
    }

    @Override
    public boolean canChangeProjectVersion() {
        return false;
    }
}
