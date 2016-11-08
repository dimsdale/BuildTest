package ua.sdo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.sdo.model.Build;

import java.util.List;

@Repository
public interface BuildRepository extends JpaRepository<Build, Integer> {

    @Query("select c from Build c where c.owner.id = :id")
    List<Build> findByIdUser(@Param("id") int id);
}
