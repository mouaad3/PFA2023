package com.PFA.emsi.service.trace;

import com.PFA.emsi.Request.TraceRequest;
import com.PFA.emsi.exception.ResourceNotFoundException;
import com.PFA.emsi.model.Trace;
import com.PFA.emsi.model.User;
import com.PFA.emsi.repository.TraceRepository;
import com.PFA.emsi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TraceServiceImpl implements TraceService{

    private final TraceRepository traceRepository;
    private final UserRepository userRepository;

    @Autowired
    public TraceServiceImpl(TraceRepository traceRepository, UserRepository userRepository) {
        this.traceRepository = traceRepository;
        this.userRepository = userRepository;
    }

    public List<Trace> getAllTraces() {
        return traceRepository.findAll();
    }

    public Trace getTraceById(Long id) {
        return traceRepository.findById(id).orElse(null);
    }

    public Trace createTrace(Long userId, String affected, String content) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        Trace trace = new Trace();
        trace.setUser(user);
        trace.setAffected(affected);
        trace.setContent(content);

        return traceRepository.save(trace);
    }

    public Trace updateTrace(Long id, TraceRequest traceRequest) {
        Trace trace = getTraceById(id);
        if (trace != null) {
            User user = userRepository.findById(traceRequest.getUserId())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + traceRequest.getUserId()));

            trace.setUser(user);
            trace.setAffected(traceRequest.getAffected());
            trace.setContent(traceRequest.getContent());

            return traceRepository.save(trace);
        }
        return null;
    }


    public void deleteTrace(Long id) {
        traceRepository.deleteById(id);
    }
}
