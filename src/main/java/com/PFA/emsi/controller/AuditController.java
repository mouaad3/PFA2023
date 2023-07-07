package com.PFA.emsi.controller;

import com.PFA.emsi.Request.AuditRequest;
import com.PFA.emsi.model.Audit;
import com.PFA.emsi.service.action.ActionServiceImpl;
import com.PFA.emsi.service.audit.AuditServiceImpl;
import com.PFA.emsi.service.process.ProcessServiceImpl;
import com.PFA.emsi.service.standard.StandardServiceImpl;
import com.PFA.emsi.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/audit")
public class AuditController {

    private final AuditServiceImpl auditService;
    private final UserService userService;
    private final ProcessServiceImpl processService;
    private final ActionServiceImpl actionService;
    private final StandardServiceImpl standardService;

    public AuditController(AuditServiceImpl auditService, UserService userService, ProcessServiceImpl processService,
                           ActionServiceImpl actionService, StandardServiceImpl standardService) {
        this.auditService = auditService;
        this.userService = userService;
        this.processService = processService;
        this.actionService = actionService;
        this.standardService = standardService;
    }
    @GetMapping("/getAllAudits")
    public ResponseEntity<List<Audit>> getAllAudits() {
        List<Audit> audits = auditService.getAllAudits();
        return new ResponseEntity<>(audits, HttpStatus.OK);
    }

    @GetMapping("/getAuditById/{id}")
    public ResponseEntity<Audit> getAuditById(@PathVariable("id") Long id) {
        Audit audit = auditService.getAuditById(id);
        if (audit != null) {
            return new ResponseEntity<>(audit, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createAudit")
    public ResponseEntity<Audit> createAudit(@RequestBody AuditRequest auditRequest) {
        Audit audit = auditService.createAudit(auditRequest);
        return ResponseEntity.ok(audit);
    }

    @PatchMapping("/updateAudit/{id}")
    public ResponseEntity<Audit> updateAudit(@PathVariable Long id, @RequestBody AuditRequest auditRequest) {
        Audit updatedAudit = auditService.updateAudit(id, auditRequest);
        return ResponseEntity.ok(updatedAudit);
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
