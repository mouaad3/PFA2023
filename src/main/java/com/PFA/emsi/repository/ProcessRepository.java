package com.PFA.emsi.repository;

import com.PFA.emsi.model.Process;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessRepository extends JpaRepository<Process, Long> {
}
