package com.bring_up.bringup.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping("/api/hello")
    public String test() {
        return "Hello, world!";
    }

}
