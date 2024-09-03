package com.example.petInsurance.factories;

import com.example.petInsurance.model.enums.DogsRace;
import com.example.petInsurance.model.impl.AbstractAnimal;
import com.example.petInsurance.model.impl.Dog;

import java.time.LocalDate;

public class DogFactory implements AnimalFactory{


    private final DogsRace race;

    public DogFactory(DogsRace race) {
        this.race = race;
    }


    @Override
    public AbstractAnimal createAnimal(LocalDate dateOfBirth, String name) {
        return new Dog(dateOfBirth, name, race);
    }
}
