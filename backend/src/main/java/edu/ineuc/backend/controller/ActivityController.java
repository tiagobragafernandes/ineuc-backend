package edu.ineuc.backend.controller;

import edu.ineuc.backend.controller.dto.CreateActivityDTO;
import edu.ineuc.backend.model.Activity;
import edu.ineuc.backend.service.ActivityService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/activity")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity createActivity(@RequestBody CreateActivityDTO createActivityDTO, UriComponentsBuilder uriBuilder){

        try {

            Activity activity = activityService.createActivity(createActivityDTO);

            var uri = uriBuilder.path("/activity/{id}").buildAndExpand(activity.getId()).toUri();

            return ResponseEntity.created(uri).body(activity);

        }catch (EntityNotFoundException ex){

            return ResponseEntity.notFound().build();

        }
    }
}
