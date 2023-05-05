package edu.ineuc.backend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Boolean isActive;

    @OneToMany(mappedBy = "user")
    private List<Activity> activity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_personal_data_id", referencedColumnName = "id")
    private UserPersonalData userPersonalData;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_role_id", referencedColumnName = "id")
    private UserRole userRole;

}
