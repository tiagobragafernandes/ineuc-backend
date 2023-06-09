package edu.ineuc.backend.model;

import edu.ineuc.backend.controller.dto.req.CreateUserRoleData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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