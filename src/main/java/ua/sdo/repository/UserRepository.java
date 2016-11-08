package ua.sdo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.sdo.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.login = :login")
    User findByName(@Param("login") String login);

}
