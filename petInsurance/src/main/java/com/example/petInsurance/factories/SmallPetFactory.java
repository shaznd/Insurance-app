package com.example.petInsurance.factories;

import com.example.petInsurance.model.impl.AbstractAnimal;
import com.example.petInsurance.model.impl.SmallPet;

import java.time.LocalDate;

public class SmallPetFactory implements AnimalFactory{

    @Override
    public AbstractAnimal createAnimal(LocalDate dateOfBirth, String name) {
        return new SmallPet( dateOfBirth);
    }
}
