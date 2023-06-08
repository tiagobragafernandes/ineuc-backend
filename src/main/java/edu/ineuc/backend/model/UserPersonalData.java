package edu.ineuc.backend.model;

import edu.ineuc.backend.controller.dto.CreateUserPersonalData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_personal_data")
public class UserPersonalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDate dob;

    @OneToOne(mappedBy = "userPersonalData", cascade = CascadeType.ALL)
    private User user;

    public UserPersonalData(CreateUserPersonalData createUserPersonalData){
        this.firstName = createUserPersonalData.firstName();
        this.lastName = createUserPersonalData.lastName();
        this.dob = createUserPersonalData.dob();
    }

}
