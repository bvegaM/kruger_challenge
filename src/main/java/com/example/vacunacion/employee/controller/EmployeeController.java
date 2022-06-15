package com.example.vacunacion.employee.controller;

import com.example.vacunacion.employee.domain.Employee;
import com.example.vacunacion.employee.domain.dto.SearchCriteria;
import com.example.vacunacion.employee.serivce.impl.EmployeeServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/employee")
@SecurityRequirement(name = "basicAuth")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping("/criteria")
    public ResponseEntity<List<Employee>> findByCriteria(@RequestBody SearchCriteria searchCriteria) {
        return ResponseEntity.ok(employeeService.findByCriteria(searchCriteria));
    }

    @PostMapping("/")
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> update(@PathVariable Integer id, @RequestBody Employee employee) throws InvocationTargetException, IllegalAccessException {
        return ResponseEntity.ok(employeeService.update(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        employeeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
