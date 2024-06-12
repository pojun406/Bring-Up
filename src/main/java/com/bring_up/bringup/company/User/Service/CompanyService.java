package com.bring_up.bringup.company.User.Service;

import com.bring_up.bringup.company.User.Entity.Company;
import com.bring_up.bringup.company.User.Repository.CompanyRepository;
import com.bring_up.bringup.company.User.dto.request.JoinDto;
import com.bring_up.bringup.company.User.dto.request.LoginDto;
import com.bring_up.bringup.company.User.dto.response.LoginTokenDto;
import com.bring_up.bringup.company.common.util.ConvertUtil;
import com.bring_up.bringup.company.User.exception.CompanyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.bring_up.bringup.company.jwt.provider.JwtProvider;

import java.util.Optional;

import static com.bring_up.bringup.company.common.enums.MemberErrorCode.DUPLICATED_MEMBER_EMAIL;
import static com.bring_up.bringup.company.common.enums.MemberErrorCode.DUPLICATED_MEMBER_PHONE_NUMBER;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    public String generateToken(String username) {
        return jwtProvider.generateToken(username);
    }

    public LoginTokenDto authenticate(LoginDto loginDto) {
        Optional<Company> companyOptional = companyRepository.findBymanagerEmail(loginDto.getUserid());
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            if (passwordEncoder.matches(loginDto.getPassword(), company.getCompanyPassword())) {
                String accessToken = jwtProvider.generateToken(loginDto.getUserid());
                return LoginTokenDto.builder()
                        .accessToken(accessToken)
                        .build();
            }
        }
        return null; // 또는 예외를 던지도록 처리
    }

    public void userProcess(Company company) {
    }

    public String joinCompany(JoinDto joinDto) {
        // 아이디 중복 체크
        if (companyRepository.existsByUserid(joinDto.getId())) {
            throw new CompanyException(DUPLICATED_MEMBER_EMAIL);
        } else if (companyRepository.existsByEmail(joinDto.getManager_phone())) {
            throw new CompanyException(DUPLICATED_MEMBER_PHONE_NUMBER);
        }

        Company company = ConvertUtil.toDtoOrEntity(joinDto, Company.class);
        company.setManagerEmail(joinDto.getId());
        company.setCompanyPassword(passwordEncoder.encode(joinDto.getPassword()));
        company.setCompanyName(joinDto.getCompany_name());
        company.setCompanyPhoneNumber(joinDto.getCompany_phone());
        company.setCompanyAddress(joinDto.getAddress());
        company.setCompanyContent(joinDto.getContent());
        company.setCompanyWelfare(joinDto.getWelfare());
        company.setCompanyVision(joinDto.getVision());
        company.setCompanyHistory(joinDto.getHistory());
        company.setManagerName(joinDto.getManager_name());
        company.setManagerPhoneNumber(joinDto.getManager_phone());
        company.setCompanySize(joinDto.getCompanysize());
        company.setCompanyLogo(joinDto.getLogo());
        company.setOpenCVKey(joinDto.getCv_key());

        String id = companyRepository.save(company).getCompanyName();

        return id;
    }
}
