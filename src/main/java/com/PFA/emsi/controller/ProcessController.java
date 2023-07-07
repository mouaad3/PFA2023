package com.PFA.emsi.controller;

import com.PFA.emsi.Request.ProcessRequest;
import com.PFA.emsi.model.Process;
import com.PFA.emsi.service.process.ProcessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/process")
public class ProcessController {

    private final ProcessServiceImpl processService;

    @Autowired
    public ProcessController(ProcessServiceImpl processService) {
        this.processService = processService;
    }

    @GetMapping("/getAllProcesses")
    public ResponseEntity<List<Process>> getAllProcesses() {
        List<Process> processes = processService.getAllProcesses();
        return ResponseEntity.ok(processes);
    }
    @GetMapping("/getProcessById/{id}")
    public ResponseEntity<Process> getProcessById(@PathVariable Long id) {
        Process process = processService.getProcessById(id);
        return ResponseEntity.ok(process);
    }

    @PostMapping("/createProcess")
    public ResponseEntity<Process> createProcess(@RequestBody ProcessRequest processRequest) {
        Process process = processService.createProcess(processRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(process);
    }
    @PatchMapping("/updateProcess/{id}")
    public ResponseEntity<Process> updateProcess(@PathVariable Long id, @RequestBody ProcessRequest processRequest) {
        Process process = processService.updateProcess(id, processRequest);
        return ResponseEntity.ok(process);
    }

    @DeleteMapping("/deleteProcess/{id}")
    public void deleteProcess(@PathVariable Long id) {
        processService.deleteProcess(id);
    }
}
