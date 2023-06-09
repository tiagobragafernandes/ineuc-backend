package edu.ineuc.backend.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthContract {

    public UserDetails loadUserByUsername(String email);

}
