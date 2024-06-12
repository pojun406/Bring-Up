package com.bring_up.bringup.company.User.Service;

import com.bring_up.bringup.company.User.Entity.Company;
import com.bring_up.bringup.company.User.Repository.CompanyRepository;
import com.bring_up.bringup.company.User.dto.request.JoinDto;
import com.bring_up.bringup.company.User.dto.request.LoginDto;
import com.bring_up.bringup.company.User.dto.response.LoginTokenDto;
import com.bring_up.bringup.company.common.util.ConvertUtil;
import com.bring_up.bringup.company.exception.MemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.bring_up.bringup.company.jwt.provider.JwtProvider;

import java.util.Optional;

import static com.bring_up.bringup.company.domain.enums.MemberErrorCode.DUPLICATED_MEMBER_EMAIL;
import static com.bring_up.bringup.company.domain.enums.MemberErrorCode.DUPLICATED_MEMBER_PHONE_NUMBER;

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

    public LoginTokenDto authenticate(LoginDto loginDto) {
        Optional<Company> companyOptional = companyRepository.findBymanagerEmail(loginDto.getUserid());
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            if (passwordEncoder.matches(loginDto.getPassword(), company.getCompanyPassword())) {
                String accessToken = jwtProvider.generateToken(loginDto.getUserid());
                String refreshToken = jwtProvider.generateToken(loginDto.getUserid()); // 실제로는 다른 방법으로 생성해야 함
                return LoginTokenDto.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
            }
        }
        return null; // 또는 예외를 던지도록 처리
    }

    public void userProcess(Company company) {
    }

    public Long joinCompany(JoinDto joinDto) {
        // 아이디 중복 체크
        if (companyRepository.existsByUserid(joinDto.getId())) {
            throw new MemberException(DUPLICATED_MEMBER_EMAIL);
        } else if (companyRepository.existsByEmail(joinDto.getPhonenum())) {
            throw new MemberException(DUPLICATED_MEMBER_PHONE_NUMBER);
        }

        Company member = ConvertUtil.toDtoOrEntity(joinDto, Company.class);
        member.setManagerEmail(joinDto.getId());
        member.setPassword(passwordEncoder.encode(joinDto.getPassword()));
        member.setEmail(joinDto.getEmail());
        member.setUsername(joinDto.getUsername());

        Long id = userRepository.save(member).getId();

        return id;
    }
}
