package edu.ineuc.backend.repository;

import edu.ineuc.backend.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {}
