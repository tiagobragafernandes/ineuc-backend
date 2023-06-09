package edu.ineuc.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.ineuc.backend.controller.dto.req.CreateActivityData;
import lombok.*;

import jakarta.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String description;
    @Column(nullable = false)
    private Integer timeSpent;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "activity_type_id")
    @JsonIgnore
    private ActivityType activityType;

    public Activity(CreateActivityData createActivityData, ActivityType activityType, User user){
        this.description = createActivityData.description();
        this.timeSpent = createActivityData.timeSpent();
        this.user = user;
        this.activityType = activityType;
    }

}
