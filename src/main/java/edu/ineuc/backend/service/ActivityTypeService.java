package edu.ineuc.backend.service;

import edu.ineuc.backend.controller.dto.CreateActivityTypeDTO;
import edu.ineuc.backend.model.ActivityType;
import edu.ineuc.backend.repository.ActivityTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ActivityTypeService {

    private final ActivityTypeRepository activityTypeRepository;

    public ActivityType createActivityType(CreateActivityTypeDTO createActivityTypeDTO){

        ActivityType activityType = activityTypeRepository.save(new ActivityType(createActivityTypeDTO));

        return activityType;

    }

}
