package edu.ineuc.backend.controller;

import edu.ineuc.backend.controller.dto.AuthDataDTO;
import edu.ineuc.backend.controller.dto.TokenResponse;
import edu.ineuc.backend.model.User;
import edu.ineuc.backend.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public ResponseEntity auth(@RequestBody AuthDataDTO authDataDTO){
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(authDataDTO.email(), authDataDTO.password());
        Authentication authentication = manager.authenticate(authToken);
        String tokenJWT  = tokenService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenResponse(tokenJWT));
    }
}
