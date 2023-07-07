package com.PFA.emsi.service.audit;

import com.PFA.emsi.Request.ActionRequest;
import com.PFA.emsi.Request.AuditRequest;
import com.PFA.emsi.exception.ResourceNotFoundException;
import com.PFA.emsi.model.Action;
import com.PFA.emsi.model.Audit;
import com.PFA.emsi.model.AuditResult;
import com.PFA.emsi.repository.AuditRepository;
import com.PFA.emsi.repository.StandardRepository;
import com.PFA.emsi.service.action.ActionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;
    private final ActionService actionService;
    private final StandardRepository standardRepository;

    @Autowired
    public AuditServiceImpl(AuditRepository auditRepository, ActionService actionService, StandardRepository standardRepository) {
        this.auditRepository = auditRepository;
        this.actionService = actionService;
        this.standardRepository = standardRepository;
    }
    public List<Audit> getAllAudits() {
        return auditRepository.findAll();
    }

    public Audit getAuditById(Long id) {
        Optional<Audit> optionalAudit = auditRepository.findById(id);
        return optionalAudit.orElse(null);
    }

    public Audit createAudit(AuditRequest auditRequest) {
        Audit audit = new Audit();
        audit.setName(auditRequest.getName());
        audit.setDescription(auditRequest.getDescription());
        audit.setStartTime(auditRequest.getStartTime());
        audit.setEndTime(auditRequest.getEndTime());

        // Set other attributes as needed
        audit.setStandard(standardRepository.findById(auditRequest.getStandardId())
                .orElseThrow(() -> new ResourceNotFoundException("Standard not found with ID: " + auditRequest.getStandardId())));

        List<Action> actions = new ArrayList<>();
        if (auditRequest.getActions() != null) {
            for (ActionRequest actionRequest : auditRequest.getActions()) {
                Action action = new Action();
                action.setName(actionRequest.getName());
                action.setDescription(actionRequest.getDescription());
                // Set other attributes for the action as needed
                action.setAudit(audit); // Set the audit for the action
                actions.add(action);
            }
        }
        audit.setActions(actions);

        // Create and set auditResult
        AuditResult auditResult = new AuditResult();
        audit.setAuditResult(auditResult);

        return auditRepository.save(audit);
    }



    @Transactional
    public Audit updateAudit(Long id, AuditRequest auditRequest) {
        Audit audit = auditRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Audit not found with ID: " + id));

        // Update the attributes based on the auditRequest
        audit.setName(auditRequest.getName());
        audit.setDescription(auditRequest.getDescription());
        audit.setStartTime(auditRequest.getStartTime());
        audit.setEndTime(auditRequest.getEndTime());

        // Update other attributes as needed
        audit.setStandard(standardRepository.findById(auditRequest.getStandardId())
                .orElseThrow(() -> new ResourceNotFoundException("Standard not found with ID: " + auditRequest.getStandardId())));

        List<Action> actions = new ArrayList<>();
        if (auditRequest.getActions() != null) {
            for (ActionRequest actionRequest : auditRequest.getActions()) {
                Action action = new Action();
                action.setName(actionRequest.getName());
                action.setDescription(actionRequest.getDescription());
                // Set other attributes for the action as needed
                action.setAudit(audit); // Set the audit for the action
                actions.add(action);
            }
        }
        audit.setActions(actions);

        return auditRepository.save(audit);
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
