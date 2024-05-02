package com.bring_up.bringup.company.TestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Test {

    private Logger log = LoggerFactory.getLogger(getClass());
    @GetMapping("/api/hello")
    public String test() {
        return "hello";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/login")
    public ResponseEntity<String> LoginTest(@RequestParam String id, @RequestParam String pw, Model model){
        String ID = "admin";
        String password = "1234";


        if(ID.equals(id) && password.equals(pw)){
            log.info("hello1");
            return ResponseEntity.ok("http://localhost:3000/company/company_main.html");
        }
        else {
            log.info("hello2");
            return ResponseEntity.badRequest().body("false");
        }
    }
}
