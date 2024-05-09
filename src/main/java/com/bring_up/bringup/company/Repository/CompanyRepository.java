package com.bring_up.bringup.company.Repository;

import com.bring_up.bringup.company.Entity.company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<company, Long> {
    Optional<company> findByUserid(String userId);
}
