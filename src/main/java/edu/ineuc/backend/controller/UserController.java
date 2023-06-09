package edu.ineuc.backend.controller;

import edu.ineuc.backend.controller.dto.req.CreateUserData;
import edu.ineuc.backend.controller.dto.res.CreateUserResponse;
import edu.ineuc.backend.controller.dto.res.DetailUserResponse;
import edu.ineuc.backend.model.User;
import edu.ineuc.backend.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/create")
    @Transactional
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserData createUserData, UriComponentsBuilder uriBuilder){
        CreateUserData data = createUserData;
        User user = userService.createUser(data);
        URI uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new CreateUserResponse(user));
    }

    @GetMapping("/{userId}")
    public ResponseEntity detailUser(@PathVariable Long userId){
        User user = userService.detailUser(userId);
        return ResponseEntity.ok().body(new DetailUserResponse(user));
    }
}
