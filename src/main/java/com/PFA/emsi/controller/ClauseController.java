package com.PFA.emsi.controller;

import com.PFA.emsi.Request.ClauseRequest;
import com.PFA.emsi.model.Clause;
import com.PFA.emsi.service.clause.ClauseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/clause")
public class ClauseController {

    private final ClauseServiceImpl clauseService;

    @Autowired
    public ClauseController(ClauseServiceImpl clauseService) {
        this.clauseService = clauseService;
    }

    @GetMapping("/getAllClauses")
    public ResponseEntity<List<Clause>> getAllClauses() {
        List<Clause> clauses = clauseService.getAllClauses();
        return new ResponseEntity<>(clauses, HttpStatus.OK);
    }

    @GetMapping("/getClauseById/{id}")
    public ResponseEntity<Clause> getClauseById(@PathVariable("id") Long id) {
        Clause clause = clauseService.getClauseById(id);
        if (clause != null) {
            return new ResponseEntity<>(clause, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createClause")
    public ResponseEntity<Clause> createClause(@RequestBody ClauseRequest clauseRequest) {
        Clause clause = new Clause();
        clause.setName(clauseRequest.getName());
        clause.setRequirements(clauseRequest.getRequirements());
        clause.setStandardId(clauseRequest.getStandardId());
        clause.setClauseResultId(clauseRequest.getClauseResultId());

        Clause savedClause = clauseService.createClause(clause);
        return ResponseEntity.ok(savedClause);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clause> updateClause(
            @PathVariable("id") Long id,
            @RequestBody Clause clause
    ) {
        Clause updatedClause = clauseService.updateClause(id, clause);
        if (updatedClause != null) {
            return new ResponseEntity<>(updatedClause, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteClause/{id}")
    public ResponseEntity<Void> deleteClause(@PathVariable("id") Long id) {
        boolean deleted = clauseService.deleteClause(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
