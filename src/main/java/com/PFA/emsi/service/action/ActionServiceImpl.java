package com.PFA.emsi.service.action;

import com.PFA.emsi.Request.ActionRequest;
import com.PFA.emsi.exception.ResourceNotFoundException;
import com.PFA.emsi.model.Action;
import com.PFA.emsi.model.Audit;
import com.PFA.emsi.model.ClauseResult;
import com.PFA.emsi.model.User;
import com.PFA.emsi.repository.ActionRepository;
import com.PFA.emsi.repository.AuditRepository;
import com.PFA.emsi.repository.ClauseResultRepository;
import com.PFA.emsi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActionServiceImpl implements ActionService {

    private final ActionRepository actionRepository;
    private final ClauseResultRepository clauseResultRepository;
    private final UserRepository userRepository;
    private final AuditRepository auditRepository;

    public ActionServiceImpl(ActionRepository actionRepository, ClauseResultRepository clauseResultRepository,
                         UserRepository userRepository, AuditRepository auditRepository) {
        this.actionRepository = actionRepository;
        this.clauseResultRepository = clauseResultRepository;
        this.userRepository = userRepository;
        this.auditRepository = auditRepository;
    }
    public List<Action> getAllActions() {
        return actionRepository.findAll();
    }

    public Action getActionById(Long id) {
        Optional<Action> optionalAction = actionRepository.findById(id);
        return optionalAction.orElse(null);
    }


    public Action createAction(ActionRequest actionRequest) {
        ClauseResult clauseResult = clauseResultRepository.findById(actionRequest.getClauseResultId())
                .orElseThrow(() -> new ResourceNotFoundException("ClauseResult not found with ID: " + actionRequest.getClauseResultId()));

        List<User> users = new ArrayList<>();
        if (actionRequest.getUserIds() != null) {
            for (Long userId : actionRequest.getUserIds()) {
                User user = userRepository.findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));
                users.add(user);
            }
        }

        Audit audit = auditRepository.findById(actionRequest.getAuditId())
                .orElseThrow(() -> new ResourceNotFoundException("Audit not found with ID: " + actionRequest.getAuditId()));

        Action action = new Action();
        action.setName(actionRequest.getName());
        action.setDescription(actionRequest.getDescription());
        action.setClauseResult(clauseResult);
        action.setUsers(users);
        action.setAudit(audit);

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
