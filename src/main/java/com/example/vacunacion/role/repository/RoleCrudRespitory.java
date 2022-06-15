package com.example.vacunacion.role.repository;

import com.example.vacunacion.role.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleCrudRespitory extends JpaRepository<Role, Integer> {

    Role findByRoleName(String name);
}

