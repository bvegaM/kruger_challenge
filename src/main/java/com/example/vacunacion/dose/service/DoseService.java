package com.example.vacunacion.dose.service;

import com.example.vacunacion.dose.domain.Dose;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface DoseService {

    public List<Dose> findAll();
    public List<Dose> findByDni(String dni);
    public Dose save(Dose dose);
    public Dose update(Integer id, Dose dose) throws InvocationTargetException, IllegalAccessException;
}
