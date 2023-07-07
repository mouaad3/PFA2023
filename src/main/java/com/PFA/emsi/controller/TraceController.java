package com.PFA.emsi.controller;

import com.PFA.emsi.Request.TraceRequest;
import com.PFA.emsi.model.Trace;
import com.PFA.emsi.service.trace.TraceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

@RequestMapping("/trace")
public class TraceController {

    private final TraceServiceImpl traceService;

    @Autowired
    public TraceController(TraceServiceImpl traceService) {
        this.traceService = traceService;
    }

    @GetMapping("/getAllTraces")
    public List<Trace> getAllTraces() {
        return traceService.getAllTraces();
    }

    @GetMapping("/getTaceById/{id}")
    public Trace getTraceById(@PathVariable Long id) {
        return traceService.getTraceById(id);
    }

    @PostMapping("/addTrace")
    public ResponseEntity<Trace> createTrace(@RequestBody TraceRequest traceRequest) {
        Trace trace = traceService.createTrace(traceRequest.getUserId(), traceRequest.getAffected(), traceRequest.getContent());
        return ResponseEntity.ok(trace);
    }

    @PatchMapping("/UpdateTrace/{id}")
    public Trace updateTrace(@PathVariable Long id, @RequestBody TraceRequest traceRequest) {
        return traceService.updateTrace(id, traceRequest);
    }

    @DeleteMapping("/deleteTrace/{id}")
    public void deleteTrace(@PathVariable Long id) {
        traceService.deleteTrace(id);
    }
}
