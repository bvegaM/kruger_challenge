package com.example.vacunacion.employee.domain;

import com.example.vacunacion.dose.domain.Dose;
import com.example.vacunacion.user.domain.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_EMPLOYEES")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Integer id;

    @NotNull(message = "El dni es requerido")
    @Column(name = "emp_dni",length = 10,unique = true)
    @Size(min = 10, max = 10, message = "El dni debe tener 10 digitos")
    @Pattern(regexp = "^[0-9]{10}$", message = "El dni debe tener 10 digitos")
    private String dni;

    @NotNull(message = "El nombre es requerido")
    @Column(name = "emp_first_name")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "El nombre solo debe contener letras")
    private String firstName;

    @NotNull(message = "El apellido es requerido")
    @Column(name = "emp_last_name")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "El nombre solo debe contener letras")
    private String lastName;

    @NotNull(message = "El email es requerido")
    @Column(name = "emp_email")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "El email no es valido")
    private String email;

    @Column(name = "emp_date_birth")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateBirth;

    @Column(name = "emp_address")
    private String address;

    @Column(name = "emp_phone_number")
    @Pattern(regexp = "^[0-9]{10}$", message = "El numero de telefono debe tener 10 digitos")
    private String phone;

    @Column(name = "emp_status_vac")
    private Boolean vaccineStatus;

    @JsonManagedReference
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Dose> doses;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_usr_id", referencedColumnName = "usr_id")
    private User user;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateBirth=" + dateBirth +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", vaccineStatus=" + vaccineStatus +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getVaccineStatus() {
        return vaccineStatus;
    }

    public void setVaccineStatus(Boolean vaccineStatus) {
        this.vaccineStatus = vaccineStatus;
    }

    public List<Dose> getDoses() {
        return doses;
    }

    public void setDoses(List<Dose> doses) {
        this.doses = doses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
