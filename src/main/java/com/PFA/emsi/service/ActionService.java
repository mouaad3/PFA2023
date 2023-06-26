package com.PFA.emsi.service;

import com.PFA.emsi.model.Action;
import com.PFA.emsi.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActionService {

    private final ActionRepository actionRepository;

    @Autowired
    public ActionService(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    public List<Action> getAllActions() {
        return actionRepository.findAll();
    }

    public Action getActionById(Long id) {
        Optional<Action> optionalAction = actionRepository.findById(id);
        return optionalAction.orElse(null);
    }

    public Action createAction(Action action) {
        return actionRepository.save(action);
    }

    public Action updateAction(Long id, Action action) {
        Optional<Action> optionalAction = actionRepository.findById(id);
        if (optionalAction.isPresent()) {
            action.setId(id);
            return actionRepository.save(action);
        } else {
            return null;
        }
    }

    public boolean deleteAction(Long id) {
        Optional<Action> optionalAction = actionRepository.findById(id);
        if (optionalAction.isPresent()) {
            actionRepository.delete(optionalAction.get());
            return true;
        } else {
            return false;
        }
    }
}
