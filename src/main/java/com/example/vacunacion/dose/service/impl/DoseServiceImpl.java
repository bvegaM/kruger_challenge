package com.example.vacunacion.dose.service.impl;

import com.example.vacunacion.dose.domain.Dose;
import com.example.vacunacion.dose.repository.DoseRepository;
import com.example.vacunacion.dose.service.DoseService;
import com.example.vacunacion.utils.NonNullBeanProperties;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class DoseServiceImpl implements DoseService {

    @Autowired
    private DoseRepository doseRepository;

    @Override
    public List<Dose> findAll() {
        return doseRepository.findAll();
    }

    @Override
    public List<Dose> findByDni(String dni) {
        return doseRepository.findByDni(dni);
    }

    @Override
    public Dose save(Dose dose) {
        doseRepository.save(dose);
        return dose;
    }

    @Override
    public Dose update(Integer id, Dose dose) throws InvocationTargetException, IllegalAccessException {
        Dose doseToUpdate = doseRepository.findById(id).get();
        BeanUtilsBean beanUtils = new NonNullBeanProperties();
        beanUtils.copyProperties(doseToUpdate, dose);
        doseRepository.save(doseToUpdate);
        return doseToUpdate;
    }
}
