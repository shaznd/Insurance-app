package com.example.petInsurance.model.impl;

import com.example.petInsurance.model.enums.DogsRace;

import java.time.LocalDate;

public class Dog extends AbstractAnimal{

    private DogsRace race;
    private String name;


    public DogsRace getRace() {
        return race;
    }

    public void setRace(DogsRace race) {
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog(LocalDate dateOfBirth, String name, DogsRace race) {
        super(dateOfBirth);
        this.race=race;
     this.name=name;
    }



public void doingDogStuffs(){
    System.out.println("woof woof!");
}

}
