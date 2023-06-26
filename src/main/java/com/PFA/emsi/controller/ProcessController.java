package com.PFA.emsi.controller;

import com.PFA.emsi.model.Process;
import com.PFA.emsi.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/processes")
public class ProcessController {

    private final ProcessService processService;

    @Autowired
    public ProcessController(ProcessService processService) {
        this.processService = processService;
    }

    @GetMapping
    public List<Process> getAllProcesses() {
        return processService.getAllProcesses();
    }

    @GetMapping("/{id}")
    public Process getProcessById(@PathVariable Long id) {
        return processService.getProcessById(id);
    }

    @PostMapping
    public Process createProcess(@RequestBody Process process) {
        return processService.createProcess(process);
    }

    @PutMapping("/{id}")
    public Process updateProcess(@PathVariable Long id, @RequestBody Process process) {
        return processService.updateProcess(id, process);
    }

    @DeleteMapping("/{id}")
    public void deleteProcess(@PathVariable Long id) {
        processService.deleteProcess(id);
    }
}
