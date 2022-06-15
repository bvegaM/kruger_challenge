package com.example.vacunacion.role.controller;

import com.example.vacunacion.role.domain.Role;
import com.example.vacunacion.role.service.impl.RoleServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@SecurityRequirement(name = "basicAuth")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("/")
    public ResponseEntity<List<Role>> findAll() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<Role> save(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.save(role));
    }
}
