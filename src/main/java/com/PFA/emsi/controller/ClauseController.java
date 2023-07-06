package com.PFA.emsi.controller;

import com.PFA.emsi.model.Clause;
import com.PFA.emsi.service.ClauseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/clauses")
public class ClauseController {

    private final ClauseService clauseService;

    @Autowired
    public ClauseController(ClauseService clauseService) {
        this.clauseService = clauseService;
    }

    @GetMapping
    public ResponseEntity<List<Clause>> getAllClauses() {
        List<Clause> clauses = clauseService.getAllClauses();
        return new ResponseEntity<>(clauses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clause> getClauseById(@PathVariable("id") Long id) {
        Clause clause = clauseService.getClauseById(id);
        if (clause != null) {
            return new ResponseEntity<>(clause, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Clause> createClause(@RequestBody Clause clause) {
        Clause createdClause = clauseService.createClause(clause);
        return new ResponseEntity<>(createdClause, HttpStatus.CREATED);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClause(@PathVariable("id") Long id) {
        boolean deleted = clauseService.deleteClause(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
