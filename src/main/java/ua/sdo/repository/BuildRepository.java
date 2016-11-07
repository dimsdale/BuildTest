package ua.sdo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.sdo.model.Build;

@Repository
public interface BuildRepository extends JpaRepository<Build, Integer> {
}
