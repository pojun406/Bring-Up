package com.bring_up.bringup.company.Repository;

import com.bring_up.bringup.company.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByUserid(String userId);
}
