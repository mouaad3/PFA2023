package com.PFA.emsi.service.process;

import com.PFA.emsi.Request.ProcessRequest;
import com.PFA.emsi.model.Process;

import java.util.List;

public interface ProcessService {

    public List<Process> getAllProcesses();
    public Process getProcessById(Long id);

    public Process createProcess(ProcessRequest processRequest);
    public Process updateProcess(Long id, ProcessRequest processRequest);
    public void deleteProcess(Long id);
}
