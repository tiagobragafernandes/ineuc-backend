package edu.ineuc.backend.controller;

import edu.ineuc.backend.controller.dto.CreateActivityTypeDTO;
import edu.ineuc.backend.model.ActivityType;
import edu.ineuc.backend.service.ActivityTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/activityType")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ActivityTypeController {

    private final ActivityTypeService activityTypeService;

    @PostMapping
    @Transactional
    public ResponseEntity createActivityType(@RequestBody CreateActivityTypeDTO createActivityTypeDTO, UriComponentsBuilder uriBuilder){

        try{

            ActivityType activityType = activityTypeService.createActivityType(createActivityTypeDTO);

            var uri = uriBuilder.path("/activityType/{id}").buildAndExpand(activityType.getId()).toUri();

            return ResponseEntity.created(uri).body(activityType);

        }catch (Exception ex){

            return ResponseEntity.badRequest().body(ex.getMessage());

        }

    }

}
