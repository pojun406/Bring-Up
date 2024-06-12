package com.bring_up.bringup.company.User.Controller;

import com.bring_up.bringup.company.User.Service.CompanyService;
import com.bring_up.bringup.company.User.Service.VerificationService;
import com.bring_up.bringup.company.User.dto.request.JoinDto;
import com.bring_up.bringup.company.User.dto.request.ValidationRequestDto;
import com.bring_up.bringup.company.common.response.BfResponse;
import com.bring_up.bringup.company.User.dto.request.LoginDto;
import com.bring_up.bringup.company.User.dto.response.LoginTokenDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.bring_up.bringup.company.common.enums.GlobalSuccessCode.CREATE;
import static com.bring_up.bringup.company.common.enums.GlobalSuccessCode.SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CompanyController {
    private CompanyService companyService;
    private VerificationService verificationService;

    /*
        "isValid" : "1" ( boolean )
     */

    @PostMapping("/Authenticity")
    public ResponseEntity<BfResponse<?>> validateBusinessNumber(
            @Valid @RequestBody ValidationRequestDto businessNumberValidateRequestDto) {
        return ResponseEntity.ok().body(new BfResponse<>(SUCCESS,
                Map.of("isValid", verificationService.verifyCompanyInfo(businessNumberValidateRequestDto))));
    }

    @PostMapping("/join")
    public ResponseEntity<BfResponse<?>> registerUser(@RequestBody JoinDto joinDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new BfResponse<>(CREATE,
                        Map.of("Company_name", companyService.joinCompany(joinDTO))));
    }

    /*
         "userid": "testuser",
        "password": "password123"
     */
    //로그인
    @PostMapping("/login")
    public ResponseEntity<BfResponse<LoginTokenDto>> login(@Valid @RequestBody LoginDto loginDto) {

        return ResponseEntity.ok(new BfResponse<>(companyService.authenticate(loginDto)));
        //return userService.login(loginDto);
    }
}
