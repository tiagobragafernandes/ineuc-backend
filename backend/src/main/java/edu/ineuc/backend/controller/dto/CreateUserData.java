package edu.ineuc.backend.controller.dto;

import edu.ineuc.backend.model.UserPersonalData;
import lombok.Data;

@Data
public class CreateUserData {

    private String email;

    private String password;

    private Boolean isActive;

}
