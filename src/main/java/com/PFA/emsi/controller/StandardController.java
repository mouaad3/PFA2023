package com.PFA.emsi.controller;

import com.PFA.emsi.Request.StandardRequest;
import com.PFA.emsi.model.Standard;
import com.PFA.emsi.service.standard.StandardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/standard")
public class StandardController {

    private final StandardServiceImpl standardService;

    @Autowired
    public StandardController(StandardServiceImpl standardService) {
        this.standardService = standardService;
    }

    @GetMapping("/getAllStandards")
    public List<Standard> getAllStandards() {
        return standardService.getAllStandards();
    }

    @GetMapping("/{id}")
    public Standard getStandardById(@PathVariable Long id) {
        return standardService.getStandardById(id);
    }

    @PostMapping("/createStandard")
    public ResponseEntity<Standard> createStandard(@RequestBody StandardRequest standardRequest) {
        Standard standard = standardService.createStandard(standardRequest);
        return ResponseEntity.ok(standard);
    }

    @PutMapping("/{id}")
    public Standard updateStandard(@PathVariable Long id, @RequestBody Standard standard) {
        return standardService.updateStandard(id, standard);
    }

    @DeleteMapping("/{id}")
    public void deleteStandard(@PathVariable Long id) {
        standardService.deleteStandard(id);
    }
}
