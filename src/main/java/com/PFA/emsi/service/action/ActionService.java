package com.PFA.emsi.service.action;

import com.PFA.emsi.Request.ActionRequest;
import com.PFA.emsi.model.Action;

import java.util.List;

public interface ActionService {


    public List<Action> getAllActions();

    public Action getActionById(Long id);

    public Action createAction(ActionRequest actionRequest);

    public Action updateAction(Long id, Action action);

    public boolean deleteAction(Long id);
}
