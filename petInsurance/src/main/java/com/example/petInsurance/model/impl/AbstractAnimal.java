package com.example.petInsurance.model.impl;

import com.example.petInsurance.model.Animal;

import java.time.LocalDate;
import java.time.Period;

public abstract  class AbstractAnimal implements Animal {


    private LocalDate dateOfBirth;

    public AbstractAnimal(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int ageCalculator() {
        if (dateOfBirth == null) {
            throw new IllegalStateException("Date of birth not set");
        }
        return Period.between(dateOfBirth, LocalDate.now()).getYears();

    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
