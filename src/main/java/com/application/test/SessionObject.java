package com.application.test;

import org.springframework.web.context.annotation.SessionScope;

@SessionScope
public class SessionObject {
    private User user = null;

    public boolean isLogged(){
        return this.user != null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
