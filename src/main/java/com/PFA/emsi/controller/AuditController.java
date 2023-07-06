package com.PFA.emsi.controller;

import com.PFA.emsi.model.Audit;
import com.PFA.emsi.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/audits")
public class AuditController {

    private final AuditService auditService;

    @Autowired
    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping
    public ResponseEntity<List<Audit>> getAllAudits() {
        List<Audit> audits = auditService.getAllAudits();
        return new ResponseEntity<>(audits, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Audit> getAuditById(@PathVariable("id") Long id) {
        Audit audit = auditService.getAuditById(id);
        if (audit != null) {
            return new ResponseEntity<>(audit, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Audit> createAudit(@RequestBody Audit audit) {
        Audit createdAudit = auditService.createAudit(audit);
        return new ResponseEntity<>(createdAudit, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Audit> updateAudit(
            @PathVariable("id") Long id,
            @RequestBody Audit audit
    ) {
        Audit updatedAudit = auditService.updateAudit(id, audit);
        if (updatedAudit != null) {
            return new ResponseEntity<>(updatedAudit, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAudit(@PathVariable("id") Long id) {
        boolean deleted = auditService.deleteAudit(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
