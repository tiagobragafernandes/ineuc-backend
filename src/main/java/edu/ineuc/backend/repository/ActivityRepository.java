package edu.ineuc.backend.repository;

import edu.ineuc.backend.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findAllByUserId(Long userId);
    Optional<Activity> findById(Long activityId);
}
