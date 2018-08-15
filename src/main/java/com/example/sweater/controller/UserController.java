package com.example.sweater.controller;

import com.example.sweater.domain.Role;
import com.example.sweater.domain.User;
import com.example.sweater.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userRepo.findAll());

        return "userList";
    }
    @GetMapping("{user}")                                              //Для данного метода мы ожидаем меппинг по мимо части "/user"
    public String userEditForm(@PathVariable User user, Model model) { // В PathVariable мы можем указать сразу User, тогда он будет
                                                                       // брать из бд без дополнитольного репозитория
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userList";
    }
}
