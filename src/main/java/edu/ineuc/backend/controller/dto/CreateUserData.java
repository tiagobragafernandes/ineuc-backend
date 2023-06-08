package edu.ineuc.backend.controller.dto;

public record CreateUserData(String email, String password, Boolean isActive, CreateUserPersonalData createUserPersonalData, CreateUserRole userType) {}
