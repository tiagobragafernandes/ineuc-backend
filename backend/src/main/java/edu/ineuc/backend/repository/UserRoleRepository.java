package edu.ineuc.backend.repository;

import edu.ineuc.backend.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {}
