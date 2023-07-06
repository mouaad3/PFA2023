package com.PFA.emsi.service;

import com.PFA.emsi.model.Trace;
import com.PFA.emsi.repository.TraceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraceService {

    private final TraceRepository traceRepository;

    @Autowired
    public TraceService(TraceRepository traceRepository) {
        this.traceRepository = traceRepository;
    }

    public List<Trace> getAllTraces() {
        return traceRepository.findAll();
    }

    public Trace getTraceById(Long id) {
        return traceRepository.findById(id).orElse(null);
    }

    public Trace createTrace(Trace trace) {
        return traceRepository.save(trace);
    }

    public Trace updateTrace(Long id, Trace updatedTrace) {
        Trace trace = getTraceById(id);
        if (trace != null) {
            trace.setUser(updatedTrace.getUser());
            trace.setAffected(updatedTrace.getAffected());
            trace.setContent(updatedTrace.getContent());
            return traceRepository.save(trace);
        }
        return null;
    }

    public void deleteTrace(Long id) {
        traceRepository.deleteById(id);
    }
}
