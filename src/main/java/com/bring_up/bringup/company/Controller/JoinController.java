/*package com.bring_up.bringup.company.Controller;

import com.bring_up.bringup.company.Entity.Company;
import com.bring_up.bringup.company.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JoinController {
    private final UserService userService;

    public JoinController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/join")
    public String joinProcess(Company company) {

        System.out.println(company.getManagerEmail());
        userService.userProcess(company);

        return "ok";
    }
}

 */
