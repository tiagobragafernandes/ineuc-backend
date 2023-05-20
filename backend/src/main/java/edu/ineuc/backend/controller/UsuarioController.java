package edu.ineuc.backend.controller;

import edu.ineuc.backend.controller.dto.CreateUserData;
import edu.ineuc.backend.model.User;
import edu.ineuc.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public ResponseEntity createUser(@RequestBody CreateUserData createUserData){

        var data = new User(createUserData);

        userRepository.save(data);

        return ResponseEntity.ok().build();

    }




}
