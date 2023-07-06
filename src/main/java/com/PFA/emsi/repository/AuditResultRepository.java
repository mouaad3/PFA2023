package com.PFA.emsi.repository;

import com.PFA.emsi.model.AuditResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditResultRepository extends JpaRepository<AuditResult, Long> {
    // Vous pouvez ajouter des méthodes spécifiques si nécessaire
}
