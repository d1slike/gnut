package ru.disdev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.disdev.model.privileges.PrivilegeType;
import ru.disdev.model.privileges.UserRole;
import ru.disdev.model.users.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dislike on 30.06.2016.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService service;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = service.getByLogin(s);
        if (user == null)
            throw new UsernameNotFoundException("User not found");
        Set<GrantedAuthority> role = new HashSet<>();
        role.add(new SimpleGrantedAuthority(user.getPrivilege() == PrivilegeType.ADMIN_PRIVILEGE
                ? UserRole.ADMIN.name()
                : UserRole.AUTHORIZED.name()));
        return new org.springframework.security.core.userdetails.User(user.getLogin(),
                user.getPassword(),
                role);
    }
}
