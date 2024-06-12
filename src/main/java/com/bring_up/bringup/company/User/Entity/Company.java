package com.bring_up.bringup.company.User.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@Setter
@Table(name = "company")
public class Company {
    @Id
    @Column(name = "manageremail", nullable = false)
    private String managerEmail; // 담당자 이메일

    @Column(name = "companyname", nullable = false)
    private String companyName; // 회사명

    @Column(name = "companypassword", nullable = false, length = 20)
    private String companyPassword; // 비번

    @Column(name = "companyscale", nullable = false, length = 30)
    private String companyScale; // 회사 규모 ( 대, 중, 소 )

    @Column(name = "companyopendate")
    private String companyOpenDate; // 개업일자

    @Column(name = "companylicense", nullable = false)
    private String companyLicense; // 사업자 등록 번호

    @Column(name = "companyphonenumber", nullable = false)
    private String companyPhoneNumber; // 회사 번호

    @Column(name = "companyadress", nullable = false)
    private String companyAddress; // 회사 주소

    @Column(name = "companycategory", nullable = false, length = 30)
    private String companyCategory; // 회사 카테고리 ( 업종 )

    @Column(name = "companycontent", nullable = false, columnDefinition = "TEXT")
    private String companyContent; // 사업내용

    @Column(name = "companywelfare", nullable = false, columnDefinition = "TEXT")
    private String companyWelfare; // 복지

    @Column(name = "companyvision", nullable = false, columnDefinition = "TEXT")
    private String companyVision; // 비전

    @Column(name = "companyhistory", nullable = false, columnDefinition = "TEXT")
    private String companyHistory; // 연혁

    @Column(name = "mastername", nullable = false, length = 10)
    private String masterName; // CEO 이름

    @Column(name = "managername", nullable = false, length = 10)
    private String managerName; // 담당자 이름

    @Column(name = "managerphonenumber", nullable = false, length = 10)
    private String managerPhoneNumber; // 담당자 번호

    @Column(name = "companysize", nullable = false)
    private int companySize; // 사원수

    @Column(name = "companylogo")
    private String companyLogo;

    @Column(name = "openCVkey", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int openCVKey;

    private Company(String manageremail, String pw) {
        this.managerEmail = manageremail;
        this.companyPassword = pw;
    }

    public Company() {
    }

    public static Company createUser(String userId, String pw, PasswordEncoder passwordEncoder) {
        return new Company(userId, passwordEncoder.encode(pw));
    }

}
