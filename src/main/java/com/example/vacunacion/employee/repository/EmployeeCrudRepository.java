package com.example.vacunacion.employee.repository;

import com.example.vacunacion.employee.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeCrudRepository extends JpaRepository<Employee, Integer> {
    Employee findByDni(String dni);
}
