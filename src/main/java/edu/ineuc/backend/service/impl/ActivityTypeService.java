package edu.ineuc.backend.service.impl;

import edu.ineuc.backend.controller.dto.req.CreateActivityTypeData;
import edu.ineuc.backend.model.ActivityType;
import edu.ineuc.backend.repository.ActivityTypeRepository;
import edu.ineuc.backend.service.ActivityTypeContract;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ActivityTypeService implements ActivityTypeContract {

    private final ActivityTypeRepository activityTypeRepository;

    public ActivityType createActivityType(CreateActivityTypeData createActivityTypeData){
        ActivityType activityType = activityTypeRepository.save(new ActivityType(createActivityTypeData));
        return activityType;
    }

}
