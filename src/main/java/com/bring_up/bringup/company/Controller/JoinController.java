package com.bring_up.bringup.company.Controller;

import com.bring_up.bringup.company.Entity.company;
import com.bring_up.bringup.company.Service.JoinService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JoinController {
    private final JoinService joinService;

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @PostMapping("/join")
    public String joinProcess(company company) {

        System.out.println(company.getUsername());
        joinService.joinProcess(company);

        return "ok";
    }
}
