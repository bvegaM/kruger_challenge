package com.example.vacunacion.dose.domain;

import com.example.vacunacion.employee.domain.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_DOSES")
public class Dose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dose_id")
    private Integer id;

    @Column(name = "dose_number")
    private Integer doseNumber;

    @Column(name = "dose_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date doseDate;

    @Column(name ="dose_vaccine")
    @Enumerated(EnumType.STRING)
    private VaccineEnum vaccineEnum;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Employee.class)
    @JoinColumn(name = "dose_emp_id", referencedColumnName = "emp_id")
    private Employee employee;

    @Override
    public String toString() {
        return "Dose{" +
                "id=" + id +
                ", doseNumber=" + doseNumber +
                ", vaccine=" + vaccineEnum +
                ", employee=" + employee +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoseNumber() {
        return doseNumber;
    }

    public void setDoseNumber(Integer doseNumber) {
        this.doseNumber = doseNumber;
    }

    public VaccineEnum getVaccine() {
        return vaccineEnum;
    }

    public void setVaccine(VaccineEnum vaccineEnum) {
        this.vaccineEnum = vaccineEnum;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getDoseDate() {
        return doseDate;
    }

    public void setDoseDate(Date doseDate) {
        this.doseDate = doseDate;
    }
}
