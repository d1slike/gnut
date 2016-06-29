package ru.disdev.model.privileges;

/**
 * Created by Dislike on 28.06.2016.
 */
final class AnonUserPrivilegeType implements PrivilegeType {
    AnonUserPrivilegeType() {

    }

    @Override
    public boolean canCreateTask() {
        return false;
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
        return false;
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
        return false;
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
