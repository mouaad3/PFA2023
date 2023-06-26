package com.PFA.emsi.repository;

import com.PFA.emsi.model.Clause;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClauseRepository extends JpaRepository<Clause, Long> {
    // Vous pouvez ajouter des méthodes spécifiques si nécessaire
}
