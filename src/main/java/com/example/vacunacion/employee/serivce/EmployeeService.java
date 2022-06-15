package com.example.vacunacion.employee.serivce;

import com.example.vacunacion.employee.domain.Employee;
import com.example.vacunacion.employee.domain.dto.SearchCriteria;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    List<Employee> findByCriteria(SearchCriteria searchCriteria);
    Employee findById(Integer id);
    Employee findByDni(String dni);
    Employee save(Employee employee);
    Employee update(Integer id, Employee employee) throws InvocationTargetException, IllegalAccessException;
    void delete(Integer id);
}
