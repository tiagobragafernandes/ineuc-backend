package edu.ineuc.backend.repository;

import edu.ineuc.backend.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findAllByUserId(Long userId);

}
