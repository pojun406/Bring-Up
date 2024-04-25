package com.bring_up.bringup.TestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping("/api/hello")
    public String test() {
        return "Hello, world!";
    }
}
