package com.PFA.emsi.controller;

import com.PFA.emsi.Request.ClauseResultRequest;
import com.PFA.emsi.model.ClauseResult;
import com.PFA.emsi.service.clauseResult.ClauseResultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/clauseresults")
public class ClauseResultController {

    private final ClauseResultServiceImpl clauseResultService;

    @Autowired
    public ClauseResultController(ClauseResultServiceImpl clauseResultService) {
        this.clauseResultService = clauseResultService;
    }

    @GetMapping("/getAllClauseResults")
    public ResponseEntity<List<ClauseResult>> getAllClauseResults() {
        List<ClauseResult> clauseResults = clauseResultService.getAllClauseResults();
        return new ResponseEntity<>(clauseResults, HttpStatus.OK);
    }

    @GetMapping("/getClauseResultById/{id}")
        public ResponseEntity<ClauseResult> getClauseResultById(@PathVariable Long id) {
            ClauseResult clauseResult = clauseResultService.getClauseResultById(id);
            return ResponseEntity.ok(clauseResult);
        }

    @PostMapping("/create")
    public ResponseEntity<ClauseResult> createClauseResult(@RequestBody ClauseResultRequest clauseResultRequest) {
        ClauseResult clauseResult = clauseResultService.createClauseResult(clauseResultRequest);
        return ResponseEntity.ok(clauseResult);
    }

    @DeleteMapping("/deleteClauseResult/{id}")
    public ResponseEntity<Void> deleteClauseResult(@PathVariable("id") Long id) {
        boolean deleted = clauseResultService.deleteClauseResult(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
