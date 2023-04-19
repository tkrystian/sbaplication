package com.application.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersDB {

    List<User> userList = new ArrayList<>();

    public void addUser(String login, String password, SessionObject sessionObject) {
        //used for creating new user
        if (getUserByLogin(login).isEmpty()) {
            userList.add(new User(login, password));
            sessionObject.setUser(getUserByLogin(login).get());
        }
//        else {
//            throw new UserExistsException();
//        }
    }

    public Optional<User> getUserByLogin(String login) {
        for (User value : userList) {
            if (value.getLogin().equals(login)) {
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }

    public void validateUser(String login, String password, SessionObject sessionObject) {
        //used for logging in
        Optional<User> validatedUser = getUserByLogin(login);
        if (validatedUser.isPresent()) {
            {
                if (validatedUser.get().getPassword().equals(password)) {
                    sessionObject.setUser(validatedUser.get());
                }
            }
        }
    }

    public UsersDB(List<User> userList) {
        this.userList = userList;
    }

    public UsersDB() {
        userList.add(new User("admin", "admin"));
        userList.add(new User("admin2", "admin2"));
    }
}
