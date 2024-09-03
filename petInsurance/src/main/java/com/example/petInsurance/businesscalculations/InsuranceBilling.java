package com.example.petInsurance.businesscalculations;

import com.example.petInsurance.model.Animal;
import com.example.petInsurance.model.InsuranceProfile;
import com.example.petInsurance.model.enums.InsuranceVariant;
import com.example.petInsurance.model.enums.DogsRace;
import com.example.petInsurance.model.impl.Cat;
import com.example.petInsurance.model.impl.Dog;
import com.example.petInsurance.model.impl.SmallPet;

import java.util.HashMap;
import java.util.Map;

public class InsuranceBilling {


    private double supportAmount;


    public static Map<String, Double> getInsuranceDetails(Animal animal, InsuranceVariant variant) {
        Map<String, Double> insuranceDetails = new HashMap<>();
        insuranceDetails.put("supportAmount", insuranceSupportAmount(animal, variant));
        insuranceDetails.put("annualPremiere", annualInsurancePremiere(animal, variant));
        return insuranceDetails;
    }

    // important method to calc the suport amount incase of an accident
    public static double insuranceSupportAmount(Animal animal, InsuranceVariant variant) {
        double basePrice = getBasePrice(animal);
        double variantMultiplier = getVariantMultiplier(variant);

        return basePrice * variantMultiplier;
    }
    // impoprtant method to calc yearly insurance price , which must payed
    public static double annualInsurancePremiere(Animal animal, InsuranceVariant variant) {
        double ageFactor = getAgeFactor(animal.ageCalculator());
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            double additionalRegulationFactor = getAdditionalRegulationFactor(dog.getRace());
            return ageFactor * insuranceSupportAmount(animal, variant) * additionalRegulationFactor;
        } else {
            return ageFactor * insuranceSupportAmount(animal, variant);
        }
    }

//    public static double insuranceSupportAmount(Animal animal, InsuranceVariant variant) {
//
//
//
//        double basePrice = getBasePrice(animal);
//
//        double variantMultiplier = getVariantMultiplier(variant);
//        return       basePrice  * variantMultiplier;
//
//    }
//
//    public static double annualInsurancePremiere(Animal animal){
//
//        double ageFactor = getAgeFactor(animal.ageCalculator());
//
//        return  ageFactor * insuranceSupportAmount(animal )
//    }

    // get the  base price based on  animal type
    private static double getBasePrice(Animal animal) {
        if (animal instanceof Dog) {

        } else if (animal instanceof Cat) {
            return 2000;
        } else if (animal instanceof SmallPet) {
            return 1000;
        } else {
            throw new IllegalArgumentException("Unknown animal type");
        }
    }

    // race factor only for dogs
    private static double getAdditionalRegulationFactor(DogsRace race) {
        switch (race) {
            case DACKLE:
                return 0.9; // 10% rabbat
            case BERNHARDINER:
                return 1.1; // 10% upprice
            default:
                return 1.0; // the same
        }
    }

    // age factor to multiply for all pets
    private static double getAgeFactor(int age) {
        if (age < 2) {
            return 0.2;
        } else if (age < 5) {
            return 0.25;
        } else if (age < 7) {
            return 0.28;
        } else {
            return 0.3;
        }
    }

    // Variant factor to multiply apply to all insurance profiles
    private static double getVariantMultiplier(InsuranceVariant variant) {


        switch (variant) {
            case COMPACT:
                return 1.0;
            case OPTIMAL:
                return 1.2;
            case PREMIUM:
                return 1.4;
            default:
                throw new IllegalArgumentException(" insurance  variant isnt defined");
        }
    }


}
