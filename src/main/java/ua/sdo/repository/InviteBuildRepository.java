package ua.sdo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.sdo.model.InviteBuild;
import ua.sdo.model.User;

import java.util.List;

@Repository
public interface InviteBuildRepository extends JpaRepository<InviteBuild, Integer> {

    @Query("select distinct c from InviteBuild c where c.user.id = :id")
    List<User> findInviteUsersByIdBuild(@Param("id") int id);
}
