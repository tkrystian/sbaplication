package com.application.test;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class AppController implements WebMvcConfigurer {

    UsersDB usersDB = new UsersDB();
    @Resource
    SessionObject sessionObject;
//    @GetMapping("/greetings")
//    public String greetings(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greetings";
//    }

//    @GetMapping("/index")
//    public String index(Model model){
//        model.addAttribute("user", new User());
//        return "index";
//    }

//    @PostMapping("/index")
//    public String indexSubmit(@ModelAttribute User user, Model model){
//        model.addAttribute("user", user);
//        return "result";
//    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(User user) {
        return "form";
    }

    @PostMapping("/")
    public String indexSubmit(User user, Model model) {
        usersDB.validateUser(user.getLogin(), user.getPassword(), sessionObject);
        if (sessionObject.isLogged()) {
            model.addAttribute("loggedUser", sessionObject.getUser().getLogin());
        } else {
            model.addAttribute("error", "Wrong login or password.");
            return "form";
        }
        return "results";
    }

    @GetMapping("/logout")
    public String logout(User user){
        sessionObject.setUser(null);
        return "form";
    }
}
