package com.PFA.emsi.controller;

import com.PFA.emsi.Request.FileRequest;
import com.PFA.emsi.model.File;
import com.PFA.emsi.service.File.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/file")
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/getAllFiles")
    public List<File> getAllFiles() {
        return fileService.getAllFiles();
    }

    @GetMapping("/getFileById/{id}")
    public File getFileById(@PathVariable Long id) {
        return fileService.getFileById(id);
    }

    @PostMapping("/createFile")
    public ResponseEntity<File> createFile(@RequestBody FileRequest fileRequest) {
        File file = fileService.createFile(fileRequest);
        return ResponseEntity.ok(file);
    }
    @PutMapping("/{id}")
    public File updateFile(@PathVariable Long id, @RequestBody File file) {
        return fileService.updateFile(id, file);
    }

    @DeleteMapping("/deleteFile/{id}")
    public void deleteFile(@PathVariable Long id) {
        fileService.deleteFile(id);
    }
}
