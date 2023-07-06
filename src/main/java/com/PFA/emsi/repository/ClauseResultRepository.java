package com.PFA.emsi.repository;

import com.PFA.emsi.model.ClauseResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClauseResultRepository extends JpaRepository<ClauseResult, Long> {
    // Vous pouvez ajouter des méthodes spécifiques si nécessaire
}
