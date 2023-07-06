package com.PFA.emsi.controller;

import com.PFA.emsi.model.Trace;
import com.PFA.emsi.service.TraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/traces")
public class TraceController {

    private final TraceService traceService;

    @Autowired
    public TraceController(TraceService traceService) {
        this.traceService = traceService;
    }

    @GetMapping
    public List<Trace> getAllTraces() {
        return traceService.getAllTraces();
    }

    @GetMapping("/{id}")
    public Trace getTraceById(@PathVariable Long id) {
        return traceService.getTraceById(id);
    }

    @PostMapping
    public Trace createTrace(@RequestBody Trace trace) {
        return traceService.createTrace(trace);
    }

    @PutMapping("/{id}")
    public Trace updateTrace(@PathVariable Long id, @RequestBody Trace trace) {
        return traceService.updateTrace(id, trace);
    }

    @DeleteMapping("/{id}")
    public void deleteTrace(@PathVariable Long id) {
        traceService.deleteTrace(id);
    }
}
