package com.bring_up.bringup.company.join;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByUserid(String userId);
}
