package com.PFA.emsi.controller;

import com.PFA.emsi.Request.AuditResultRequest;
import com.PFA.emsi.exception.ResourceNotFoundException;
import com.PFA.emsi.model.Audit;
import com.PFA.emsi.model.AuditResult;
import com.PFA.emsi.model.ClauseResult;
import com.PFA.emsi.repository.AuditRepository;
import com.PFA.emsi.repository.AuditResultRepository;
import com.PFA.emsi.repository.ClauseResultRepository;
import com.PFA.emsi.service.AuditResult.AuditResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/auditResult")
public class AuditResultController {

    private final AuditResultService auditResultService;

    private final AuditRepository auditRepository;

    private final ClauseResultRepository clauseResultRepository;

    private final AuditResultRepository auditResultRepository;

    @Autowired
    public AuditResultController(AuditResultService auditResultService, AuditRepository auditRepository, ClauseResultRepository clauseResultRepository, AuditResultRepository auditResultRepository) {
        this.auditResultService = auditResultService;
        this.auditRepository = auditRepository;
        this.clauseResultRepository = clauseResultRepository;
        this.auditResultRepository = auditResultRepository;
    }

    @GetMapping("/getAllAuditResults")
    public ResponseEntity<List<AuditResult>> getAllAuditResults() {
        List<AuditResult> auditResults = auditResultService.getAllAuditResults();
        return new ResponseEntity<>(auditResults, HttpStatus.OK);
    }

    @GetMapping("/getAuditResultById/{id}")
    public ResponseEntity<AuditResult> getAuditResultById(@PathVariable("id") Long id) {
        AuditResult auditResult = auditResultService.getAuditResultById(id);
        if (auditResult != null) {
            return new ResponseEntity<>(auditResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<AuditResult> createAuditResult(@RequestBody AuditResultRequest auditResultRequest) {
        AuditResult auditResult = new AuditResult();
        auditResult.setDescription(auditResultRequest.getDescription());
        // Set other attributes as needed

        // Set the associated audit
        if (auditResultRequest.getAuditId() != null) {
            Optional<Audit> auditOptional = auditRepository.findById(auditResultRequest.getAuditId());
            if (auditOptional.isPresent()) {
                Audit audit = auditOptional.get();
                auditResult.setAudit(audit);
            } else {
                throw new ResourceNotFoundException("Audit not found with ID: " + auditResultRequest.getAuditId());
            }
        }

        // Set the associated clause result
        if (auditResultRequest.getClauseResultId() != null) {
            Optional<ClauseResult> clauseResultOptional = clauseResultRepository.findById(auditResultRequest.getClauseResultId());
            if (clauseResultOptional.isPresent()) {
                ClauseResult clauseResult = clauseResultOptional.get();
                auditResult.setClauseResults(clauseResult);
            } else {
                throw new ResourceNotFoundException("ClauseResult not found with ID: " + auditResultRequest.getClauseResultId());
            }
        }

        AuditResult savedAuditResult = auditResultRepository.save(auditResult);
        return ResponseEntity.ok(savedAuditResult);
    }


    @PutMapping("/{id}")
    public ResponseEntity<AuditResult> updateAuditResult(
            @PathVariable("id") Long id,
            @RequestBody AuditResult auditResult
    ) {
        AuditResult updatedAuditResult = auditResultService.updateAuditResult(id, auditResult);
        if (updatedAuditResult != null) {
            return new ResponseEntity<>(updatedAuditResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteAuditResult/{id}")
    public ResponseEntity<Void> deleteAuditResult(@PathVariable("id") Long id) {
        boolean deleted = auditResultService.deleteAuditResult(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
