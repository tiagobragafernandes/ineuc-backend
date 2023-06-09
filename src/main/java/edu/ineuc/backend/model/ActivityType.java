package edu.ineuc.backend.model;

import edu.ineuc.backend.controller.dto.CreateActivityTypeDTO;
import lombok.*;
import java.util.List;

import jakarta.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "activity_type")
public class ActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "activityType", fetch = FetchType.LAZY)
    private List<Activity> activity;

    public ActivityType(CreateActivityTypeDTO createActivityTypeDTO){
        this.name = createActivityTypeDTO.name();
    }

}
