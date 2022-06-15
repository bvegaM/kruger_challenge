package com.example.vacunacion.role.repository;

import com.example.vacunacion.role.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepository {

    @Autowired
    private RoleCrudRespitory roleCrudRespitory;

    public List<Role> findAll() {
        return roleCrudRespitory.findAll();
    }

    public Role findByName(String name) {
        return roleCrudRespitory.findByRoleName(name);
    }

    public void save(Role role) {
        roleCrudRespitory.save(role);
    }
}
