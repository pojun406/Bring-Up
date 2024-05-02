package com.bring_up.bringup.company.TestController;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping("/api/hello")
    public String test() {
        return "hello";
    }

    @GetMapping("/api/login")
    public ResponseEntity<String> LoginTest(@RequestParam String id, @RequestParam String pw, Model model){
        String ID = "admin";
        String password = "1234";

        if(ID.equals(id) && password.equals(pw))
            return ResponseEntity.ok("http://localhost:3000/company/company_main.html");
        else
            return ResponseEntity.badRequest().body("false");
    }
}
