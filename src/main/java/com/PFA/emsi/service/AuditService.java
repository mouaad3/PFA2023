package com.PFA.emsi.service;

import com.PFA.emsi.model.Audit;
import com.PFA.emsi.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditService {

    private final AuditRepository auditRepository;

    @Autowired
    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    public List<Audit> getAllAudits() {
        return auditRepository.findAll();
    }

    public Audit getAuditById(Long id) {
        Optional<Audit> optionalAudit = auditRepository.findById(id);
        return optionalAudit.orElse(null);
    }

    public Audit createAudit(Audit audit) {
        return auditRepository.save(audit);
    }

    public Audit updateAudit(Long id, Audit audit) {
        Optional<Audit> optionalAudit = auditRepository.findById(id);
        if (optionalAudit.isPresent()) {
            audit.setId(id);
            return auditRepository.save(audit);
        } else {
            return null;
        }
    }

    public boolean deleteAudit(Long id) {
        Optional<Audit> optionalAudit = auditRepository.findById(id);
        if (optionalAudit.isPresent()) {
            auditRepository.delete(optionalAudit.get());
            return true;
        } else {
            return false;
        }
    }
}
