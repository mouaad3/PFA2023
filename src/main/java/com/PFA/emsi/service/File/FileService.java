package com.PFA.emsi.service.File;

import com.PFA.emsi.Request.FileRequest;
import com.PFA.emsi.exception.ResourceNotFoundException;
import com.PFA.emsi.model.File;
import com.PFA.emsi.model.Proof;
import com.PFA.emsi.repository.FileRepository;
import com.PFA.emsi.repository.ProofRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private final FileRepository fileRepository;
    private final ProofRepository proofRepository;

    public FileService(FileRepository fileRepository, ProofRepository proofRepository) {
        this.fileRepository = fileRepository;
        this.proofRepository = proofRepository;
    }

    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }

    public File getFileById(Long id) {
        return fileRepository.findById(id).orElse(null);
    }

    public File createFile(FileRequest fileRequest) {
        Proof proof = proofRepository.findById(fileRequest.getProofId())
                .orElseThrow(() -> new ResourceNotFoundException("Proof not found with ID: " + fileRequest.getProofId()));

        File file = new File();
        file.setName(fileRequest.getName());
        file.setContent(fileRequest.getContent());
        file.setProof(proof);

        return fileRepository.save(file);
    }
    public File updateFile(Long id, File updatedFile) {
        File file = getFileById(id);
        if (file != null) {
            file.setName(updatedFile.getName());
            file.setContent(updatedFile.getContent());
            file.setProof(updatedFile.getProof());
            return fileRepository.save(file);
        }
        return null;
    }

    public void deleteFile(Long id) {
        fileRepository.deleteById(id);
    }
}
