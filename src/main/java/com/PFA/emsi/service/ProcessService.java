package com.PFA.emsi.service;

import com.PFA.emsi.model.Process;
import com.PFA.emsi.repository.ProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessService {

    private final ProcessRepository processRepository;

    @Autowired
    public ProcessService(ProcessRepository processRepository) {
        this.processRepository = processRepository;
    }

    public List<Process> getAllProcesses() {
        return processRepository.findAll();
    }

    public Process getProcessById(Long id) {
        return processRepository.findById(id).orElse(null);
    }

    public Process createProcess(Process process) {
        return processRepository.save(process);
    }

    public Process updateProcess(Long id, Process updatedProcess) {
        Process process = getProcessById(id);
        if (process != null) {
            process.setName(updatedProcess.getName());
            process.setDescription(updatedProcess.getDescription());
            process.setSite(updatedProcess.getSite());
            process.setProcessManager(updatedProcess.getProcessManager());
            process.setAudits(updatedProcess.getAudits());
            return processRepository.save(process);
        }
        return null;
    }

    public void deleteProcess(Long id) {
        processRepository.deleteById(id);
    }
}
