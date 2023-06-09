package edu.ineuc.backend.service;

import edu.ineuc.backend.controller.dto.req.CreateActivityData;
import edu.ineuc.backend.model.Activity;

import java.util.List;

public interface ActivityContract {
    public Activity createActivity(CreateActivityData createActivityData);
    public List<Activity> listActivities(Long userId);
}
