package com.example.vacunacion.user.service;

import com.example.vacunacion.user.domain.User;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface UserService {

    public List<User> findAll();
    public User findByUsername(String username);
    public User save(User user);
    public User update(Integer id, User user) throws InvocationTargetException, IllegalAccessException;

}
