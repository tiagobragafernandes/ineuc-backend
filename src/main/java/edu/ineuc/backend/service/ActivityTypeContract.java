package edu.ineuc.backend.service;

import edu.ineuc.backend.controller.dto.req.CreateActivityTypeData;
import edu.ineuc.backend.model.ActivityType;

public interface ActivityTypeContract {

    public ActivityType createActivityType(CreateActivityTypeData createActivityTypeData);

}
