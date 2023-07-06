package com.PFA.emsi.service;

import com.PFA.emsi.model.File;
import com.PFA.emsi.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private final FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }

    public File getFileById(Long id) {
        return fileRepository.findById(id).orElse(null);
    }

    public File createFile(File file) {
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
