package com.PFA.emsi.service.proofService;

import com.PFA.emsi.Request.ProofRequest;
import com.PFA.emsi.exception.ResourceNotFoundException;
import com.PFA.emsi.model.ClauseResult;
import com.PFA.emsi.model.File;
import com.PFA.emsi.model.Proof;
import com.PFA.emsi.repository.ClauseResultRepository;
import com.PFA.emsi.repository.FileRepository;
import com.PFA.emsi.repository.ProofRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProofService {

    private final ProofRepository proofRepository;
    private final ClauseResultRepository clauseResultRepository;
    private final FileRepository fileRepository;

    public ProofService(ProofRepository proofRepository, ClauseResultRepository clauseResultRepository, FileRepository fileRepository) {
        this.proofRepository = proofRepository;
        this.clauseResultRepository = clauseResultRepository;
        this.fileRepository = fileRepository;
    }
    public List<Proof> getAllProofs() {
        return proofRepository.findAll();
    }

    public Proof getProofById(Long id) {
        return proofRepository.findById(id).orElse(null);
    }

    public Proof createProof(ProofRequest proofRequest) {
        ClauseResult clauseResult = clauseResultRepository.findById(proofRequest.getClauseResultId())
                .orElseThrow(() -> new ResourceNotFoundException("ClauseResult not found with ID: " + proofRequest.getClauseResultId()));

        List<File> files = fileRepository.findAllById(proofRequest.getFileIds());

        Proof proof = new Proof();
        proof.setDescription(proofRequest.getDescription());
        proof.setClauseResult(clauseResult);
        proof.setFiles(files);

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
