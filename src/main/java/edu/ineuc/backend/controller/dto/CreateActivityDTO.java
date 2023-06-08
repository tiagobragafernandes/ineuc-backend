package edu.ineuc.backend.controller.dto;

public record CreateActivityDTO(String description, Integer timeSpent, Long userId, Long activityId) {}
