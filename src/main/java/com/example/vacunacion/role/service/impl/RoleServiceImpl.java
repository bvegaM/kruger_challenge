package com.example.vacunacion.role.service.impl;

import com.example.vacunacion.role.domain.Role;
import com.example.vacunacion.role.repository.RoleRepository;
import com.example.vacunacion.role.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    
    private static final Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public Role save(Role role) {
        roleRepository.save(role);
        log.info(role.toString());
        return role;
    }
}
