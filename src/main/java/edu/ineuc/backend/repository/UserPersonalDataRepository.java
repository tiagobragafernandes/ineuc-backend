package edu.ineuc.backend.repository;

import edu.ineuc.backend.model.UserPersonalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPersonalDataRepository extends JpaRepository<UserPersonalData, Long> {}
