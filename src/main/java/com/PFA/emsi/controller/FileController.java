package com.PFA.emsi.controller;

import com.PFA.emsi.model.File;
import com.PFA.emsi.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/files")
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping
    public List<File> getAllFiles() {
        return fileService.getAllFiles();
    }

    @GetMapping("/{id}")
    public File getFileById(@PathVariable Long id) {
        return fileService.getFileById(id);
    }

    @PostMapping
    public File createFile(@RequestBody File file) {
        return fileService.createFile(file);
    }

    @PutMapping("/{id}")
    public File updateFile(@PathVariable Long id, @RequestBody File file) {
        return fileService.updateFile(id, file);
    }

    @DeleteMapping("/{id}")
    public void deleteFile(@PathVariable Long id) {
        fileService.deleteFile(id);
    }
}
