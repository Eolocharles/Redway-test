package com.eolo.app.controllers;

import com.eolo.app.entities.User;
import com.eolo.app.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    private final UserRepository userRepository;

    public FormController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/save")
    public String save(User user) {
        userRepository.save(user);
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }
}
