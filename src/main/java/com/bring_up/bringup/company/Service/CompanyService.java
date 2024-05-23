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

    public Company registerUser(Company companyDTO) {
        // 비밀번호를 암호화하여 저장
        Company company = new Company();
        company.setManagerEmail(companyDTO.getManagerEmail());
        company.setCompanyPassword(passwordEncoder.encode(companyDTO.getCompanyPassword()));
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
