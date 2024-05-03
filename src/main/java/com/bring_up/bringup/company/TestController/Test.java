package com.bring_up.bringup.company.TestController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Test {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hello, Thymeleaf!");
        return "index";
    }

    @GetMapping("/api/login")
    public String LoginTest(@RequestParam String id, @RequestParam String pw, Model model){
        String ID = "admin";
        String password = "1234";

        if(ID.equals(id) && password.equals(pw))
            return "./company/company_main";
        else
            return "false";
    }
}