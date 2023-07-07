package com.PFA.emsi.controller;

import com.PFA.emsi.Request.ProofRequest;
import com.PFA.emsi.model.Proof;
import com.PFA.emsi.service.proofService.ProofService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/proof")
public class ProofController {

    private final ProofService proofService;

    @Autowired
    public ProofController(ProofService proofService) {
        this.proofService = proofService;
    }

    @GetMapping("/getAllProofs")
    public List<Proof> getAllProofs() {
        return proofService.getAllProofs();
    }

    @GetMapping("/getProofById/{id}")
    public Proof getProofById(@PathVariable Long id) {
        return proofService.getProofById(id);
    }

    @PostMapping("/createProof")
    public ResponseEntity<Proof> createProof(@RequestBody ProofRequest proofRequest) {
        Proof proof = proofService.createProof(proofRequest);
        return ResponseEntity.ok(proof);
    }
    @PutMapping("/{id}")
    public Proof updateProof(@PathVariable Long id, @RequestBody Proof proof) {
        return proofService.updateProof(id, proof);
    }

    @DeleteMapping("/deleteProof/{id}")
    public void deleteProof(@PathVariable Long id) {
        proofService.deleteProof(id);
    }
}
