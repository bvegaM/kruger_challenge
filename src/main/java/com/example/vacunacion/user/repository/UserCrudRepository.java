package com.example.vacunacion.user.repository;

import com.example.vacunacion.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCrudRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
