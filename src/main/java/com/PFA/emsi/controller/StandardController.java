package com.PFA.emsi.controller;

import com.PFA.emsi.model.Standard;
import com.PFA.emsi.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/standards")
public class StandardController {

    private final StandardService standardService;

    @Autowired
    public StandardController(StandardService standardService) {
        this.standardService = standardService;
    }

    @GetMapping
    public List<Standard> getAllStandards() {
        return standardService.getAllStandards();
    }

    @GetMapping("/{id}")
    public Standard getStandardById(@PathVariable Long id) {
        return standardService.getStandardById(id);
    }

    @PostMapping
    public Standard createStandard(@RequestBody Standard standard) {
        return standardService.createStandard(standard);
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
