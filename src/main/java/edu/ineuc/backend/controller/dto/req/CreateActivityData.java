package edu.ineuc.backend.controller.dto.req;

public record CreateActivityData(String description, Integer timeSpent, Long userId, Long activityId) {}
