package edu.ineuc.backend.service.impl;

import edu.ineuc.backend.controller.dto.req.CreateActivityData;
import edu.ineuc.backend.model.Activity;
import edu.ineuc.backend.model.ActivityType;
import edu.ineuc.backend.model.User;
import edu.ineuc.backend.repository.ActivityRepository;
import edu.ineuc.backend.repository.ActivityTypeRepository;
import edu.ineuc.backend.repository.UserRepository;
import edu.ineuc.backend.service.ActivityContract;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ActivityService implements ActivityContract {

    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;
    private final ActivityTypeRepository activityTypeRepository;

    public Activity createActivity(CreateActivityData createActivityData){
        Long activityId = createActivityData.activityId();
        Long userId = createActivityData.userId();

        ActivityType activityType = activityTypeRepository.findById(activityId)
                .orElseThrow(() ->
                        new EntityNotFoundException("ERRO: Atividade com id: " + activityId + " não foi encontrada.")
                );

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new EntityNotFoundException("ERRO: Usuário com id: " + userId + " não foi encontrada.")
                );

        Activity activity = activityRepository.save(new Activity(createActivityData, activityType, user));
        return activity;
    }

    public List<Activity> listActivities(Long userId){
        List<Activity> activities = activityRepository.findAllByUserId(userId);
        return activities;
    }

}
