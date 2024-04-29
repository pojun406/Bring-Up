package com.bring_up.bringup.company.TestController;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class Test {

    @GetMapping("/api/hello")
    public String test() {
        return "Hello, world!";
    }

    @PostMapping("/api/login")
    public String loginTest(@RequestParam("id") String id, @RequestParam("password") String password){
        if(id.equals("admin") && password.equals("password"))
            return "ok";
        else
            return "false";
    }
}
