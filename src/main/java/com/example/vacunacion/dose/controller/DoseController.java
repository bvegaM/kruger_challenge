package com.example.vacunacion.dose.controller;

import com.example.vacunacion.dose.domain.Dose;
import com.example.vacunacion.dose.service.impl.DoseServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/dose")
@SecurityRequirement(name = "basicAuth")
public class DoseController {

    @Autowired
    private DoseServiceImpl doseService;

    @GetMapping("/")
    public ResponseEntity<List<Dose>> findAll() {
        return ResponseEntity.ok(doseService.findAll());
    }

    @GetMapping("/{dni}")
    public ResponseEntity<List<Dose>> findByDni(@PathVariable String dni) {
        return ResponseEntity.ok(doseService.findByDni(dni));
    }

    @PostMapping("/")
    public ResponseEntity<Dose> save(@RequestBody Dose dose) {
        return ResponseEntity.ok(doseService.save(dose));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dose> update(@PathVariable Integer id, @RequestBody Dose dose) throws InvocationTargetException, IllegalAccessException {
        return ResponseEntity.ok(doseService.update(id,dose));
    }

}
