package edu.ineuc.backend.controller;

import edu.ineuc.backend.controller.dto.AuthData;
import edu.ineuc.backend.controller.dto.TokenResponse;
import edu.ineuc.backend.model.User;
import edu.ineuc.backend.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AuthController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity auth(@RequestBody AuthData authData){

        var authToken = new UsernamePasswordAuthenticationToken(authData.email(), authData.password());

        var authentication = manager.authenticate(authToken);

        var tokenJWT  = tokenService.gerarToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenResponse(tokenJWT));

    }
}
