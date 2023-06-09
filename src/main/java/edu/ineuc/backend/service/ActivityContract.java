package edu.ineuc.backend.service;

import edu.ineuc.backend.controller.dto.CreateActivityDTO;
import edu.ineuc.backend.model.Activity;

import java.util.List;

public interface ActivityContract {

    public Activity createActivity(CreateActivityDTO createActivityDTO);
    public List<Activity> listActivities(Long userId);

}
