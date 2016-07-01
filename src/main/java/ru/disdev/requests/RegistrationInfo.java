package ru.disdev.requests;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Dislike on 01.07.2016.
 */
public class RegistrationInfo {
    @Size(min = 3, max = 20, message = "Минимальное количество символов - 3, максимальное - 20")
    @Pattern(regexp = "^[a-zA-Z0-9]+$",
            message = "Логин должен состаять из цифр и букв из латинского алфавита")
    private String login;
    @Size(min = 3, max = 20, message = "Минимальное количество символов - 3, максимальное - 20")
    private String password;
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",
            message = "Неверный формат адреса")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
