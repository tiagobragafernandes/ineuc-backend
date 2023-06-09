package edu.ineuc.backend.model;

import edu.ineuc.backend.controller.dto.req.CreateUserPersonalData;
import lombok.*;

import jakarta.persistence.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
