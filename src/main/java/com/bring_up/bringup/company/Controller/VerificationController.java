package com.bring_up.bringup.company.Controller;

import static com.bring_up.bringup.company.domain.enums.GlobalSuccessCode.SUCCESS;

import com.bring_up.bringup.company.Service.VerificationService;
import com.bring_up.bringup.company.domain.response.BfResponse;
import com.bring_up.bringup.company.dto.ValidationRequestDto;
import com.bring_up.bringup.company.dto.ValidationRequestInfo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/api")
public class VerificationController {
    private final VerificationService verificationService;

    @Autowired
    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @PostMapping("/Authenticity")
    public ResponseEntity<BfResponse<?>> validateBusinessNumber(
            @Valid @RequestBody ValidationRequestDto businessNumberValidateRequestDto) {
        return ResponseEntity.ok().body(new BfResponse<>(SUCCESS,
                Map.of("isValid", verificationService.verifyCompanyInfo(businessNumberValidateRequestDto))));
    }
}
