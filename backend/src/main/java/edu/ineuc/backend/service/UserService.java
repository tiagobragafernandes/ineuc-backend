package edu.ineuc.backend.service;

import edu.ineuc.backend.controller.dto.CreateUserData;
import edu.ineuc.backend.model.User;
import edu.ineuc.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public User createUser(CreateUserData createUserData){

        var encryptedPassword = passwordEncoder.encode(createUserData.password());

        User user = userRepository.save(new User(createUserData));

        return user;

    }

}
