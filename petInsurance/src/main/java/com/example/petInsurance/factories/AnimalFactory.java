package com.example.petInsurance.factories;

import com.example.petInsurance.model.impl.AbstractAnimal;

import java.time.LocalDate;

public interface AnimalFactory {



     AbstractAnimal createAnimal(LocalDate dateOfBirth, String name);
}
