package com.example.vacunacion.dose.repository;

import com.example.vacunacion.dose.domain.Dose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DoseRepository {

    @Autowired
    private DoseCrudRepository doseCrudRepository;

    public List<Dose> findByDni(String dni) {
        return doseCrudRepository.findByEmployee_Dni(dni);
    }

    public List<Dose> findAll() {
        return doseCrudRepository.findAll();
    }

    public Optional<Dose> findById(Integer id) {
        return doseCrudRepository.findById(id);
    }

    public void save(Dose dose) {
        doseCrudRepository.save(dose);
    }
}
