package com.PFA.emsi.controller;

import com.PFA.emsi.model.Proof;
import com.PFA.emsi.service.ProofService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/proofs")
public class ProofController {

    private final ProofService proofService;

    @Autowired
    public ProofController(ProofService proofService) {
        this.proofService = proofService;
    }

    @GetMapping
    public List<Proof> getAllProofs() {
        return proofService.getAllProofs();
    }

    @GetMapping("/{id}")
    public Proof getProofById(@PathVariable Long id) {
        return proofService.getProofById(id);
    }

    @PostMapping
    public Proof createProof(@RequestBody Proof proof) {
        return proofService.createProof(proof);
    }

    @PutMapping("/{id}")
    public Proof updateProof(@PathVariable Long id, @RequestBody Proof proof) {
        return proofService.updateProof(id, proof);
    }

    @DeleteMapping("/{id}")
    public void deleteProof(@PathVariable Long id) {
        proofService.deleteProof(id);
    }
}
