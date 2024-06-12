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
    private String managerEmail;

    @Column(name = "companyname", nullable = false)
    private String companyName;

    @Column(name = "companypassword", nullable = false, length = 20)
    private String companyPassword;

    @Column(name = "companycategory", nullable = false, length = 30)
    private String companyCategory;

    @Column(name = "companyopendate")
    private String companyOpenDate;

    @Column(name = "companylicense", nullable = false)
    private String companyLicense;

    @Column(name = "companyphonenumber")
    private String companyPhoneNumber;

    @Column(name = "companyadress", nullable = false)
    private String companyAddress;

    @Column(name = "companycontent", nullable = false, columnDefinition = "TEXT")
    private String companyContent;

    @Column(name = "companywelfare", nullable = false, columnDefinition = "TEXT")
    private String companyWelfare;

    @Column(name = "companyvision", nullable = false, columnDefinition = "TEXT")
    private String companyVision;

    @Column(name = "companyhistory", nullable = false, columnDefinition = "TEXT")
    private String companyHistory;

    @Column(name = "mastername", nullable = false, length = 10)
    private String masterName;

    @Column(name = "managername", nullable = false, length = 10)
    private String managerName;

    @Column(name = "managerphonenumber", nullable = false, length = 10)
    private String managerPhoneNumber;

    @Column(name = "companysize", nullable = false)
    private int companySize;

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
