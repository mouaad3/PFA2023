package com.PFA.emsi.controller;


import com.PFA.emsi.model.Action;
import com.PFA.emsi.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/actions")
public class ActionController {

    private final ActionService actionService;

    @Autowired
    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }

    @GetMapping
    public ResponseEntity<List<Action>> getAllActions() {
        List<Action> actions = actionService.getAllActions();
        return new ResponseEntity<>(actions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Action> getActionById(@PathVariable("id") Long id) {
        Action action = actionService.getActionById(id);
        if (action != null) {
            return new ResponseEntity<>(action, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Action> createAction(@RequestBody Action action) {
        Action createdAction = actionService.createAction(action);
        return new ResponseEntity<>(createdAction, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Action> updateAction(
            @PathVariable("id") Long id,
            @RequestBody Action action
    ) {
        Action updatedAction = actionService.updateAction(id, action);
        if (updatedAction != null) {
            return new ResponseEntity<>(updatedAction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAction(@PathVariable("id") Long id) {
        boolean deleted = actionService.deleteAction(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
