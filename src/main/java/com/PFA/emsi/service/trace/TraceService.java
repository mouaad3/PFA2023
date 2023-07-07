package com.PFA.emsi.service.trace;

import com.PFA.emsi.Request.TraceRequest;
import com.PFA.emsi.model.Trace;

import java.util.List;

public interface TraceService {

    public List<Trace> getAllTraces();
    public Trace getTraceById(Long id);

    public Trace createTrace(Long userId, String affected, String content);

    public Trace updateTrace(Long id, TraceRequest traceRequest);

    public void deleteTrace(Long id);
}
