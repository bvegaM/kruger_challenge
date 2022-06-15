package com.example.vacunacion.employee.repository;

import com.example.vacunacion.dose.domain.Dose;
import com.example.vacunacion.employee.domain.Employee;
import com.example.vacunacion.employee.domain.dto.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    public List<Employee> findAll() {
        List<Employee> employees = employeeCrudRepository.findAll();
        return employees;
    }

    public Employee findByDni(String dni) {
        return employeeCrudRepository.findByDni(dni);
    }

    public void save(Employee employee) {
        employeeCrudRepository.save(employee);
    }

    public Optional<Employee> findById(Integer id) {
        return employeeCrudRepository.findById(id);
    }

    public List<Employee> findByCriteria(SearchCriteria criteria){
        List<Employee> employees = employeeCrudRepository.findAll();
        // filter employees wby status
        if (criteria.getVaccineStatus()!= null) {
            employees = employees.stream().filter(Employee::getVaccineStatus).collect(Collectors.toList());
        }
        if(criteria.getVaccine()!= null){
            employees = employees.stream().filter(employee -> employee.getDoses().stream().anyMatch(dose -> dose.getVaccine().getName().equals(criteria.getVaccine()))).collect(Collectors.toList());
        }
       if(criteria.getStartDate()!=null || criteria.getEndDate()!=null){
           //convert date to String
           String startDate = criteria.getStartDate().toString();
           String endDate = criteria.getEndDate().toString();
           employees = employees.stream().filter(employee -> employee.getDoses().stream().anyMatch(dose -> {
               if (criteria.getStartDate()!=null && criteria.getEndDate()==null){
                     return dose.getDoseDate().after(criteria.getStartDate());
               }
               if (criteria.getStartDate()==null && criteria.getEndDate()!=null){
                   return dose.getDoseDate().before(criteria.getStartDate());
               }
               return dose.getDoseDate().after(criteria.getStartDate()) && dose.getDoseDate().before(criteria.getEndDate());
           })).collect(Collectors.toList());
       }
        //employees = employees.stream().filter(employee -> employee.getDoses().stream().anyMatch(dose -> dose.getDoseDate().after(java.sql.Date.valueOf("2022-01-01")) && dose.getDoseDate().before(java.sql.Date.valueOf("2022-06-13")))).collect(Collectors.toList());
        return employees;
    }

    public void delete(Integer id) {
        employeeCrudRepository.deleteById(id);
    }

}
