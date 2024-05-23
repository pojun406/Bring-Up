package com.bring_up.bringup.company.Controller;

import com.bring_up.bringup.company.Entity.Company;
import com.bring_up.bringup.company.Service.CompanyService;
import com.bring_up.bringup.company.Service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/join")
    public String registerUser(@RequestBody Company user) {
        companyService.registerUser(user);
        return "ok";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        String token = companyService.authenticate(email, password);
        if (token != null) {
            return ResponseEntity.ok("로그인 성공: " + token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("유효하지 않은 자격 증명");
        }
    }
}
