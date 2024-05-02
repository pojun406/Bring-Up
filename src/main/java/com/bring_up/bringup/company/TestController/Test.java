package com.bring_up.bringup.company.TestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class Test {

    private Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/")
    public String hello(Model model){
        return "index";
    }

    @GetMapping("/api/hello")
    public String test() {
        return "hello";
    }

    @GetMapping("/api/login")
    public ResponseEntity<String> LoginTest(@RequestParam String exampleInputEmail1, @RequestParam String exampleInputPassword1, Model model){
        String ID = "admin";
        String password = "1234";


        if(ID.equals(exampleInputEmail1) && password.equals(exampleInputPassword1)){
            log.info("hello1");
            return ResponseEntity.ok("http://localhost:3000/company/company_main.html");
        }
        else {
            log.info("hello2");
            return ResponseEntity.badRequest().body("false");
        }
    }
}
