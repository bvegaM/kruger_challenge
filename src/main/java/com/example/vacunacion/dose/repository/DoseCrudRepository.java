package com.example.vacunacion.dose.repository;

import com.example.vacunacion.dose.domain.Dose;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoseCrudRepository extends JpaRepository<Dose, Integer> {

    List<Dose> findByEmployee_Dni(String dni);
}
