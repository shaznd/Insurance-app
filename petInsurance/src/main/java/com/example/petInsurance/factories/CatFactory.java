package com.example.petInsurance.factories;

import com.example.petInsurance.model.impl.AbstractAnimal;
import com.example.petInsurance.model.impl.Cat;

import java.time.LocalDate;

public class CatFactory implements AnimalFactory{
    @Override
    public AbstractAnimal createAnimal(LocalDate dateOfBirth, String name) {
        return new Cat(dateOfBirth, name);
    }
}
