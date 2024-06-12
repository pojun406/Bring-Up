package com.bring_up.bringup.company.User.Repository;

import com.bring_up.bringup.company.User.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findBymanagerEmail(String managerEmail);

    Optional<Company> findBycompanyPassword(String companyPassword);

    Company save(Company company);

    boolean existsByUserid(String id);

    boolean existsByEmail(String id);
}
