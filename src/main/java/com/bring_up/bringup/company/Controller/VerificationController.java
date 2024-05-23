package com.bring_up.bringup.company.Controller;

import com.bring_up.bringup.company.Entity.Company;
import com.bring_up.bringup.company.Service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VerificationController {
    private final VerificationService verificationService;

    @Autowired
    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @PostMapping("/Authenticity")
    public String authenticity(@RequestBody Company user){
        // VerificationService의 메서드에 전달
        boolean isValid = verificationService.verifyCompanyInfo(user.getCompanyOpenDate(), user.getCompanyLicense(), user.getMasterName());
        if (isValid) {
            return "ok";
        } else {
            return "fail";
        }
    }
}
