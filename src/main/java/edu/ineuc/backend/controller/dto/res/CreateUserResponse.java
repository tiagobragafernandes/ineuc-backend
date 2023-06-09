package edu.ineuc.backend.controller.dto.res;

import edu.ineuc.backend.controller.dto.req.CreateUserPersonalData;
import edu.ineuc.backend.model.User;
import edu.ineuc.backend.model.UserRole;

public record CreateUserResponse(Long userId, String email, String FirstName, String userRole) {

    public CreateUserResponse(User user){
        this(user.getId(), user.getEmail(), user.getUserPersonalData().getFirstName(), user.getUserRole().getUserType());
    }

}
