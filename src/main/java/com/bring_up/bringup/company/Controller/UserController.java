package com.bring_up.bringup.company.Controller;

import com.bring_up.bringup.company.Entity.Company;
import com.bring_up.bringup.company.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody Company user) {
        userService.registerUser(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody Company company) {
        String token = userService.generateToken(company.getManagerEmail());
        return "Token: " + token;
    }
}
