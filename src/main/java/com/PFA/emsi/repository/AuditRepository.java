package com.PFA.emsi.repository;

import com.PFA.emsi.model.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Long> {
    // Vous pouvez ajouter des méthodes spécifiques si nécessaire
}
