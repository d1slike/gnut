package ru.disdev.model.privileges;

/**
 * Created by Dislike on 28.06.2016.
 */
final class AdminUserPrivilegeType implements PrivilegeType {

    AdminUserPrivilegeType() {

    }

    @Override
    public boolean canCreateTask() {
        return true;
    }

    @Override
    public boolean canEditTask() {
        return true;
    }

    @Override
    public boolean canCloseAnyTask() {
        return true;
    }

    @Override
    public boolean canAddMessage() {
        return true;
    }

    @Override
    public boolean canEditMessage() {
        return true;
    }

    @Override
    public boolean canDeleteMessage() {
        return true;
    }

    @Override
    public boolean canEditHisInformation() {
        return true;
    }

    @Override
    public boolean canEditAnyUser() {
        return true;
    }

    @Override
    public boolean canChangeProjectVersion() {
        return true;
    }
}
