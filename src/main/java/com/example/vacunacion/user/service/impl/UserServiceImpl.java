package com.example.vacunacion.user.service.impl;

import com.example.vacunacion.user.domain.User;
import com.example.vacunacion.user.repository.UserRepository;
import com.example.vacunacion.user.service.UserService;
import com.example.vacunacion.utils.NonNullBeanProperties;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public User update(Integer id, User user) throws InvocationTargetException, IllegalAccessException {
        BeanUtilsBean beanUtils = new NonNullBeanProperties();
        User userToUpdate = userRepository.findById(id).get();
        beanUtils.copyProperties(userToUpdate, user);
        userRepository.save(userToUpdate);
        return userToUpdate;
    }

}
