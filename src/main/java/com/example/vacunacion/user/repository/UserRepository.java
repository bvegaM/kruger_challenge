package com.example.vacunacion.user.repository;

import com.example.vacunacion.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> findAll() {
        return userCrudRepository.findAll();
    }

    public void save (User user) {
        userCrudRepository.save(user);
    }

    public Optional<User> findById(Integer id) {
        return userCrudRepository.findById(id);
    }

    public User findByUsername(String username) {
        return userCrudRepository.findByUsername(username);
    }
}
