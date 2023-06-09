package edu.ineuc.backend.service;

import edu.ineuc.backend.controller.dto.CreateActivityTypeDTO;
import edu.ineuc.backend.model.ActivityType;

public interface ActivityTypeContract {

    public ActivityType createActivityType(CreateActivityTypeDTO createActivityTypeDTO);

}
