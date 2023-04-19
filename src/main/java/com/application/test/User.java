package com.application.test;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User {

    private int id;
    @NotNull
    @Size(min=2, max=30)
    private String login;
    @NotNull
    @Size(min=2, max=30)
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
