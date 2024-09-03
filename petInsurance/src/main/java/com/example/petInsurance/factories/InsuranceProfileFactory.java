package com.example.petInsurance.factories;

import com.example.petInsurance.model.Animal;
import com.example.petInsurance.model.InsuranceProfile;
import com.example.petInsurance.model.enums.InsuranceVariant;

import java.time.LocalDate;

public class InsuranceProfileFactory {


    public static InsuranceProfile createInsuranceProfile(String name, String family, int age, String adress, Animal insuredPet, InsuranceVariant variant, LocalDate DateOfIssue){

        return  new InsuranceProfile( name, family, age, adress, insuredPet, variant, DateOfIssue );
    }
}
