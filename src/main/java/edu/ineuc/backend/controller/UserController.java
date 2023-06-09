package edu.ineuc.backend.controller;

import edu.ineuc.backend.controller.dto.CreateUserData;
import edu.ineuc.backend.model.User;
import edu.ineuc.backend.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/create")
    @Transactional
    public ResponseEntity createUser(@RequestBody CreateUserData createUserData, UriComponentsBuilder uriBuilder){
        CreateUserData data = createUserData;
        User user = userService.createUser(data);
        URI uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }
}
