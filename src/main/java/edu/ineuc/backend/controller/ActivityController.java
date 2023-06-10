package edu.ineuc.backend.controller;

import edu.ineuc.backend.controller.dto.req.CreateActivityData;
import edu.ineuc.backend.model.Activity;
import edu.ineuc.backend.service.impl.ActivityService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/activity")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    @Transactional
    public ResponseEntity createActivity(@RequestBody CreateActivityData createActivityData, UriComponentsBuilder uriBuilder){
        try {
            Activity activity = activityService.createActivity(createActivityData);
            URI uri = uriBuilder.path("/activity/{id}").buildAndExpand(activity.getId()).toUri();
            return ResponseEntity.created(uri).body(activity);
        }catch (EntityNotFoundException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Activity>> listActivities(@PathVariable Long userId){
        try{
            List<Activity> activities = activityService.listActivities(userId);
            return ResponseEntity.ok(activities);
        }catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }
}
