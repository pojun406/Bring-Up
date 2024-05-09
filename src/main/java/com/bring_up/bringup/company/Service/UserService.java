package com.bring_up.bringup.company.Service;

import com.bring_up.bringup.company.Entity.Company;
import com.bring_up.bringup.company.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import provider.JwtProvider;

@Service
public class UserService {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    public Company registerUser(Company company) {
        // 비밀번호를 암호화하여 저장
        company.setCompanyPassword(passwordEncoder.encode(company.getCompanyPassword()));
        return companyRepository.save(company);
    }

    public String generateToken(String username) {
        return jwtProvider.generateToken(username);
    }

    public void userProcess(Company company) {
    }
}
