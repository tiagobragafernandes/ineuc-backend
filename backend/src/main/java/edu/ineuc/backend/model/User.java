package edu.ineuc.backend.model;

import edu.ineuc.backend.controller.dto.CreateUserData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
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
    @JoinColumn(name = "userPersonalData", referencedColumnName = "id")
    private UserPersonalData userPersonalData;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userRole", referencedColumnName = "id")
    private UserRole userRole;

    public User(CreateUserData data) {
        this.email = data.getEmail();
        this.password = data.getPassword();
        this.isActive = data.getIsActive();
    }

}
