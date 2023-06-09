package edu.ineuc.backend.service.impl;

import edu.ineuc.backend.controller.dto.req.CreateUserData;
import edu.ineuc.backend.model.User;
import edu.ineuc.backend.repository.UserRepository;
import edu.ineuc.backend.service.UserContract;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserService implements UserContract {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public User createUser(CreateUserData createUserData){
        String encryptedPassword = passwordEncoder.encode(createUserData.password());
        User user = userRepository.save(new User(createUserData, encryptedPassword));
        return user;
    }

    @Override
    public User detailUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));

        return user;
    }
}
