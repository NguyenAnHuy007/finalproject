package com.samsung.finalproject.controller;

import com.samsung.finalproject.models.entities.User;
import com.samsung.finalproject.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginPage(Model model, @RequestParam(defaultValue = "") String error)
    {
        User user = new User();
        model.addAttribute("user", user);model.addAttribute("error", error);
        return "Login";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, Model model) {
        userService.registerUser(username, password);
        model.addAttribute("message", "Đăng ký thành công! Hãy đăng nhập.");
        return "login";
    }
}
