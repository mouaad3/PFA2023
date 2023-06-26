package com.PFA.emsi.service;

import com.PFA.emsi.model.AuditResult;
import com.PFA.emsi.repository.AuditResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditResultService {

    private final AuditResultRepository auditResultRepository;

    @Autowired
    public AuditResultService(AuditResultRepository auditResultRepository) {
        this.auditResultRepository = auditResultRepository;
    }

    public List<AuditResult> getAllAuditResults() {
        return auditResultRepository.findAll();
    }

    public AuditResult getAuditResultById(Long id) {
        Optional<AuditResult> optionalAuditResult = auditResultRepository.findById(id);
        return optionalAuditResult.orElse(null);
    }

    public AuditResult createAuditResult(AuditResult auditResult) {
        return auditResultRepository.save(auditResult);
    }

    public AuditResult updateAuditResult(Long id, AuditResult auditResult) {
        Optional<AuditResult> optionalAuditResult = auditResultRepository.findById(id);
        if (optionalAuditResult.isPresent()) {
            auditResult.setId(id);
            return auditResultRepository.save(auditResult);
        } else {
            return null;
        }
    }

    public boolean deleteAuditResult(Long id) {
        Optional<AuditResult> optionalAuditResult = auditResultRepository.findById(id);
        if (optionalAuditResult.isPresent()) {
            auditResultRepository.delete(optionalAuditResult.get());
            return true;
        } else {
            return false;
        }
    }
}
