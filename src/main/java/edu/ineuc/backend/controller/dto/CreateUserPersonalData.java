package edu.ineuc.backend.controller.dto;

import java.time.LocalDate;

public record CreateUserPersonalData(String firstName, String lastName, LocalDate dob) {
}
