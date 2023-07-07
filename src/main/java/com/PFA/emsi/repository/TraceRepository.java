package com.PFA.emsi.repository;

import com.PFA.emsi.model.Trace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraceRepository extends JpaRepository<Trace, Long> {

}
