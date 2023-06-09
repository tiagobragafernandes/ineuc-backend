package edu.ineuc.backend.controller.dto.res;

import edu.ineuc.backend.model.User;

public record DetailUserResponse(String firstName, String lastName, String email, Boolean isActive) {

   public DetailUserResponse(User user){
       this(user.getUserPersonalData().getFirstName(), user.getUserPersonalData().getLastName(), user.getEmail(), user.getIsActive());
   }

}
