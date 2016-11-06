package ua.sdo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.sdo.model.Build;


public interface BuildRepository extends JpaRepository<Build, Integer> {
}
