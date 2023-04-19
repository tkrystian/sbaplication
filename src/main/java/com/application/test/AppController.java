package com.application.test;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController{

    UsersDB usersDB = new UsersDB();
    @Resource
    SessionObject sessionObject;

    @GetMapping(value = {"/", "/login"})
    public String showLoginPage(User user) {
        return "login";
    }

    @PostMapping("/")
    public String loginPage(User user, Model model) {
        usersDB.validateUser(user.getLogin(), user.getPassword(), sessionObject);
        if (sessionObject.isLogged()) {
            model.addAttribute("sessionObject", sessionObject);
        } else {
            model.addAttribute("error", "Wrong login or password.");
            return "login";
        }
        return "main";
    }

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("sessionObject", sessionObject);
        return "main";
    }

    @GetMapping("/logout")
    public String logout(User user){
        sessionObject.setUser(null);
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage(User user){
        return "register";
    }

    @PostMapping("/register")
    public String registerPage(User user, Model model) {
        usersDB.addUser(user.getLogin(), user.getPassword(), sessionObject);
        if (sessionObject.isLogged()) {
            model.addAttribute("sessionObject", sessionObject);
        } else {
            model.addAttribute("error", "Login already exists.");
            return "register";
        }
        return "main";
    }
}
