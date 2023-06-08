package edu.ineuc.backend.model;

import edu.ineuc.backend.controller.dto.CreateUserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

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

    public UserRole(CreateUserRole userType) {
        this.userType = userType.userType();
    }

}