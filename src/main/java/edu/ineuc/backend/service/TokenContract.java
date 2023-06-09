package edu.ineuc.backend.service;

import edu.ineuc.backend.model.User;


public interface TokenContract {
    public String generateToken(User user);
    public String getSubject(String tokenJWT);
}
