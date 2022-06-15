package com.example.vacunacion.dose.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum VaccineEnum {

    SPUTNIK("Sputnik"),
    ASTRAZENECA("AstraZeneca"),
    PFIZER("Pfizer"),
    JHONSON("Johnson&Johnson");

    private String name;

    VaccineEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
