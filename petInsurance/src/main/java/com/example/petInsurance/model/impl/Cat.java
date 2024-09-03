package com.example.petInsurance.model.impl;

import java.time.LocalDate;

public class Cat  extends AbstractAnimal{



    private String name;
    public Cat(LocalDate dateOfBirth, String name) {

        super(dateOfBirth);
        this.name= name;
    }
}
