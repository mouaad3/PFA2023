package com.PFA.emsi.controller;

import com.PFA.emsi.model.ClauseResult;
import com.PFA.emsi.service.ClauseResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/clause-results")
public class ClauseResultController {

    private final ClauseResultService clauseResultService;

    @Autowired
    public ClauseResultController(ClauseResultService clauseResultService) {
        this.clauseResultService = clauseResultService;
    }

    @GetMapping
    public ResponseEntity<List<ClauseResult>> getAllClauseResults() {
        List<ClauseResult> clauseResults = clauseResultService.getAllClauseResults();
        return new ResponseEntity<>(clauseResults, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClauseResult> getClauseResultById(@PathVariable("id") Long id) {
        ClauseResult clauseResult = clauseResultService.getClauseResultById(id);
        if (clauseResult != null) {
            return new ResponseEntity<>(clauseResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ClauseResult> createClauseResult(@RequestBody ClauseResult clauseResult) {
        ClauseResult createdClauseResult = clauseResultService.createClauseResult(clauseResult);
        return new ResponseEntity<>(createdClauseResult, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClauseResult> updateClauseResult(
            @PathVariable("id") Long id,
            @RequestBody ClauseResult clauseResult
    ) {
        ClauseResult updatedClauseResult = clauseResultService.updateClauseResult(id, clauseResult);
        if (updatedClauseResult != null) {
            return new ResponseEntity<>(updatedClauseResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClauseResult(@PathVariable("id") Long id) {
        boolean deleted = clauseResultService.deleteClauseResult(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
