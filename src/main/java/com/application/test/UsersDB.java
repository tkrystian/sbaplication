package com.application.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersDB {

    List<User> userList = new ArrayList<>();

    public void addUser(String login, String password) {
        //used for creating new user
        if (getUserByLogin(login).isEmpty()) {
            userList.add(new User(login, password));
        } else {
            throw new UserExistsException();
        }
    }

    public Optional<User> getUserByLogin(String login) {
        for (User value : userList) {
            if (value.getLogin().equals(login)) {
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }

    public Optional<User> validateUser(String login, String password) {
        //used for logging in
        Optional<User> validatedUser = getUserByLogin(login);
        if (validatedUser.isEmpty()) {
            throw new EmptyUserException();
        }
        if (validatedUser.get().getPassword().equals(password)) {
            return validatedUser;
        }
        return Optional.empty();
    }

    public UsersDB(List<User> userList) {
        this.userList = userList;
    }

    public UsersDB() {
        userList.add(new User("admin", "admin"));
    }
}
