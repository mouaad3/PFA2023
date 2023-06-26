package com.PFA.emsi.repository;

import com.PFA.emsi.model.Standard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandardRepository extends JpaRepository<Standard, Long> {
}
