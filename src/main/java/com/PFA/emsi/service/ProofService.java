package com.PFA.emsi.service;

import com.PFA.emsi.model.Proof;
import com.PFA.emsi.repository.ProofRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProofService {

    private final ProofRepository proofRepository;

    @Autowired
    public ProofService(ProofRepository proofRepository) {
        this.proofRepository = proofRepository;
    }

    public List<Proof> getAllProofs() {
        return proofRepository.findAll();
    }

    public Proof getProofById(Long id) {
        return proofRepository.findById(id).orElse(null);
    }

    public Proof createProof(Proof proof) {
        return proofRepository.save(proof);
    }

    public Proof updateProof(Long id, Proof updatedProof) {
        Proof proof = getProofById(id);
        if (proof != null) {
            proof.setFiles(updatedProof.getFiles());
            proof.setDescription(updatedProof.getDescription());
            proof.setClauseResult(updatedProof.getClauseResult());
            return proofRepository.save(proof);
        }
        return null;
    }

    public void deleteProof(Long id) {
        proofRepository.deleteById(id);
    }
}
