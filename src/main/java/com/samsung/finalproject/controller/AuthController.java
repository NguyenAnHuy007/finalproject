package com.samsung.finalproject.controller;

import com.samsung.finalproject.models.entities.User;
import com.samsung.finalproject.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        model.addAttribute("user", user);
        model.addAttribute("error", error);
        return "Login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User()); // Gắn object User vào form
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute User user, Model model) {
        if (userService.findByUsername(user.getUsername()) != null) {
            model.addAttribute("message", "Tên đăng nhập đã tồn tại!");
            return "register";
        }

        userService.registerUser(user.getUsername(), user.getPassword());
        model.addAttribute("message", "Đăng ký thành công! Hãy đăng nhập.");
        return "login";
    }

}
