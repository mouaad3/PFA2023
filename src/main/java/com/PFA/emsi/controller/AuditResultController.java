package com.PFA.emsi.controller;

import com.PFA.emsi.model.AuditResult;
import com.PFA.emsi.service.AuditResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/audit-results")
public class AuditResultController {

    private final AuditResultService auditResultService;

    @Autowired
    public AuditResultController(AuditResultService auditResultService) {
        this.auditResultService = auditResultService;
    }

    @GetMapping
    public ResponseEntity<List<AuditResult>> getAllAuditResults() {
        List<AuditResult> auditResults = auditResultService.getAllAuditResults();
        return new ResponseEntity<>(auditResults, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditResult> getAuditResultById(@PathVariable("id") Long id) {
        AuditResult auditResult = auditResultService.getAuditResultById(id);
        if (auditResult != null) {
            return new ResponseEntity<>(auditResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<AuditResult> createAuditResult(@RequestBody AuditResult auditResult) {
        AuditResult createdAuditResult = auditResultService.createAuditResult(auditResult);
        return new ResponseEntity<>(createdAuditResult, HttpStatus.CREATED);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuditResult(@PathVariable("id") Long id) {
        boolean deleted = auditResultService.deleteAuditResult(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
