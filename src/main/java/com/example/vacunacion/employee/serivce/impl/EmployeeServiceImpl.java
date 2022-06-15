package com.example.vacunacion.employee.serivce.impl;

import com.example.vacunacion.employee.domain.Employee;
import com.example.vacunacion.employee.domain.dto.SearchCriteria;
import com.example.vacunacion.employee.repository.EmployeeRepository;
import com.example.vacunacion.employee.serivce.EmployeeService;
import com.example.vacunacion.role.repository.RoleRepository;
import com.example.vacunacion.user.domain.User;
import com.example.vacunacion.utils.NonNullBeanProperties;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByCriteria(SearchCriteria searchCriteria) {
        return employeeRepository.findByCriteria(searchCriteria);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee findByDni(String dni) {
        return employeeRepository.findByDni(dni);
    }

    @Override
    public Employee save(Employee employee) {
        User user = new User();
        String username = employee.getFirstName().split(" ")[0].toLowerCase().charAt(0) + employee.getLastName().toLowerCase();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(employee.getDni()));
        user.setRole(roleRepository.findByName("user"));
        employee.setUser(user);
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee update(Integer id, Employee employee) throws InvocationTargetException, IllegalAccessException {
        Employee employeeToUpdate = employeeRepository.findById(id).get();
        BeanUtilsBean beanUtils = new NonNullBeanProperties();
        beanUtils.copyProperties(employeeToUpdate, employee);
        employeeRepository.save(employeeToUpdate);
        return employeeToUpdate;
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.delete(id);
    }
}
