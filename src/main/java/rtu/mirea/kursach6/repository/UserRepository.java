package rtu.mirea.kursach6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rtu.mirea.kursach6.model.User;


import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> deleteByName(String name);
    List<User> findByNameAndPassword(String name, String password);
}