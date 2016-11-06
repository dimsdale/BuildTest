package ua.sdo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.sdo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
