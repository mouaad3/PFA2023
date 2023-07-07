package com.PFA.emsi.service.process;

import com.PFA.emsi.Request.ProcessRequest;
import com.PFA.emsi.exception.ResourceNotFoundException;
import com.PFA.emsi.model.Audit;
import com.PFA.emsi.model.Process;
import com.PFA.emsi.model.Site;
import com.PFA.emsi.model.User;
import com.PFA.emsi.repository.AuditRepository;
import com.PFA.emsi.repository.ProcessRepository;
import com.PFA.emsi.repository.SiteRepository;
import com.PFA.emsi.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {

    private final ProcessRepository processRepository;
    private final UserRepository userRepository;
    private final AuditRepository auditRepository;
    private final SiteRepository siteRepository;

    public ProcessServiceImpl(ProcessRepository processRepository, UserRepository userRepository,
                              AuditRepository auditRepository, SiteRepository siteRepository) {
        this.processRepository = processRepository;
        this.userRepository = userRepository;
        this.auditRepository = auditRepository;
        this.siteRepository = siteRepository;
    }
    public List<Process> getAllProcesses() {
        return processRepository.findAll();
    }

    @Override
    public Process getProcessById(Long id) {
        return processRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Process not found with ID: " + id));
    }

    @Override
    public Process createProcess(ProcessRequest processRequest) {
        Process process = new Process();
        process.setName(processRequest.getName());
        process.setDescription(processRequest.getDescription());

        User processManager = userRepository.findById(processRequest.getProcessManagerId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + processRequest.getProcessManagerId()));
        process.setProcessManager(processManager);

        if (processRequest.getAuditIds() != null) {
            List<Audit> audits = auditRepository.findAllById(processRequest.getAuditIds());
            process.setAudit(audits);
        }

        Site site = siteRepository.findById(processRequest.getSiteId())
                .orElseThrow(() -> new ResourceNotFoundException("Site not found with ID: " + processRequest.getSiteId()));
        process.setSite(site);

        return processRepository.save(process);
    }
    @Transactional
    public Process updateProcess(Long id, ProcessRequest processRequest) {
        Process process = processRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Process not found with ID: " + id));

        // Update the process attributes if provided
        if (processRequest.getName() != null) {
            process.setName(processRequest.getName());
        }
        if (processRequest.getDescription() != null) {
            process.setDescription(processRequest.getDescription());
        }

        // Update the process manager if provided
        if (processRequest.getProcessManagerId() != null) {
            User processManager = userRepository.findById(processRequest.getProcessManagerId())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + processRequest.getProcessManagerId()));
            process.setProcessManager(processManager);
        }

        // Update the audits if provided
        if (processRequest.getAuditIds() != null) {
            List<Audit> audits = new ArrayList<>();
            for (Long auditId : processRequest.getAuditIds()) {
                Audit audit = auditRepository.findById(auditId)
                        .orElseThrow(() -> new ResourceNotFoundException("Audit not found with ID: " + auditId));
                audits.add(audit);
            }
            process.setAudit(audits);
        }

        // Update the site if provided
        if (processRequest.getSiteId() != null) {
            Site site = siteRepository.findById(processRequest.getSiteId())
                    .orElseThrow(() -> new ResourceNotFoundException("Site not found with ID: " + processRequest.getSiteId()));
            process.setSite(site);
        }

        return processRepository.save(process);
    }


    @Override
    public void deleteProcess(Long id) {
        processRepository.deleteById(id);
    }
}
