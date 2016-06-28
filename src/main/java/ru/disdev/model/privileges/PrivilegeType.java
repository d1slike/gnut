package ru.disdev.model.privileges;

import java.io.Serializable;

/**
 * Created by Dislike on 28.06.2016.
 */
public interface PrivilegeType extends Serializable {

    PrivilegeType ADMIN_PRIVILEGE = new AdminUserPrivilegeType();
    PrivilegeType AUTHORIZED_USER_PRIVILEGE = new AuthorizedUserPrivilegeType();
    PrivilegeType ANON_USER_PRIVILEGE = new AnonUserPrivilegeType();

    boolean canCreateTask();
    boolean canEditTask();
    boolean canCloseAnyTask();
    boolean canAddMessage();
    boolean canEditMessage();
    boolean canDeleteMessage();
    boolean canEditHisInformation();
    boolean canEditAnyUser();
    boolean canChangeProjectVersion();
}
