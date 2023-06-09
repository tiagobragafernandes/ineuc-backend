package edu.ineuc.backend.service;

import edu.ineuc.backend.controller.dto.req.CreateUserData;
import edu.ineuc.backend.model.User;

public interface UserContract {

    public User createUser(CreateUserData createUserData);

    public User detailUser(Long id);

}
