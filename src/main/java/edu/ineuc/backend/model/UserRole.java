package edu.ineuc.backend.model;

import edu.ineuc.backend.controller.dto.req.CreateUserRoleData;
import lombok.*;

import jakarta.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userType;
    @OneToOne(mappedBy = "userRole", cascade = CascadeType.ALL)
    private User user;

    public UserRole(CreateUserRoleData userType) {
        this.userType = userType.userType();
    }

}