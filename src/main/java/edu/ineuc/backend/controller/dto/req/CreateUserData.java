package edu.ineuc.backend.controller.dto.req;

public record CreateUserData(String email, String password, Boolean isActive, CreateUserPersonalData createUserPersonalData, CreateUserRoleData userType) {}
