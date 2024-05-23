package com.bring_up.bringup.company.Service;

import com.bring_up.bringup.company.Entity.Company;
import com.bring_up.bringup.company.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import provider.JwtProvider;

import java.util.Optional;

@Service
@ComponentScan(basePackages={"config"})
@ComponentScan(basePackages={"provider"})
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    private VerificationService verificationService;

    public Company authtoapi(Company companyDTO) {
        // 필요한 정보 추출
        String openDate = companyDTO.getCompanyOpenDate();
        int license = companyDTO.getCompanyLicense();
        String masterName = companyDTO.getMasterName();

        // 정보 검증
        boolean isValid = verificationService.verifyCompanyInfo(openDate, license, masterName);

        if (isValid) {
            // 새로운 Company 엔티티 생성
            Company company = new Company();
            company.setCompanyOpenDate(openDate);
            company.setCompanyLicense(license);
            company.setMasterName(masterName);
            // 레파지토리에 저장
            return companyRepository.save(company);
        } else {
            // 정보가 유효하지 않은 경우 처리, 예외를 던지거나 null 반환
            throw new IllegalArgumentException("유효하지 않은 회사 정보입니다");
        }
    }

    public Company registerUser(Company companyDTO) {
        // 비밀번호를 암호화하여 저장
        Company company = new Company();
        company.setManagerEmail(companyDTO.getManagerEmail());
        company.setCompanyPassword(passwordEncoder.encode(companyDTO.getCompanyPassword()));
        company.setCompanyName(companyDTO.getCompanyName());
        company.setManagerName(companyDTO.getManagerName());
        company.setCompanyPhoneNumber(companyDTO.getCompanyPhoneNumber());
        company.setCompanyAddress(companyDTO.getCompanyAddress());
        company.setCompanyContent(companyDTO.getCompanyContent());
        company.setCompanyWelfare(companyDTO.getCompanyWelfare());
        company.setCompanyVision(companyDTO.getCompanyVision());
        company.setCompanyHistory(companyDTO.getCompanyHistory());
        company.setManagerName(companyDTO.getManagerName());
        company.setManagerPhoneNumber(companyDTO.getManagerPhoneNumber());
        company.setCompanySize(companyDTO.getCompanySize());
        company.setCompanyLogo(companyDTO.getCompanyLogo());
        company.setOpenCVKey(companyDTO.getOpenCVKey());

        return companyRepository.save(company);
    }

    public String generateToken(String username) {
        return jwtProvider.generateToken(username);
    }

    public String authenticate(String email, String password) {
        Optional<Company> companyemail = companyRepository.findBymanagerEmail(email);
        Optional<Company> companypassword = companyRepository.findBycompanyPassword(password);
         if (companyemail.isPresent() && companypassword.isPresent()){
             String id = email;
             return generateToken(id); // 인증 성공
         } else{
             return null; // 인증 실패
         }
    }

    public void userProcess(Company company) {
    }
}
