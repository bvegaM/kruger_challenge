package com.example.vacunacion.role.service;

import com.example.vacunacion.role.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();
    Role save(Role role);
}
