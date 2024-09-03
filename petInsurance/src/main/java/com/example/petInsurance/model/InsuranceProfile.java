package com.example.petInsurance.model;

import com.example.petInsurance.businesscalculations.AvailabilityChecker;
import com.example.petInsurance.businesscalculations.InsuranceBilling;
import com.example.petInsurance.model.enums.InsuranceVariant;

import java.time.LocalDate;
import java.util.Map;

import static com.example.petInsurance.businesscalculations.InsuranceBilling.getInsuranceDetails;

public class InsuranceProfile {

        private String personName;
        private String personFamily;
        private int personAge;
        private String personAddress;
        private Animal insuredPet;  // dog cat small pet or etc...
        private InsuranceVariant insuranceVariant;
        private LocalDate dateOfIssue;


        // constructors
        public InsuranceProfile(String personName, String personFamily, int personAge, String personAddress, Animal insuredPet, InsuranceVariant insuranceVariant, LocalDate dateOfIssue) {
            this.personName = personName;
            this.personFamily = personFamily;
            this.personAge = personAge;
            this.personAddress = personAddress;
            this.insuredPet = insuredPet;
            this.insuranceVariant = insuranceVariant;
            this.dateOfIssue=dateOfIssue;
        }

        // getter and setter



    public InsuranceVariant getInsuranceVariant() {
        return this.insuranceVariant;
    }

    public void setInsuranceVariant(InsuranceVariant insuranceVariant) {
        this.insuranceVariant = insuranceVariant;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    //a  Method to  check the availabilty of the insurance variant on the date of issue and also calculate the insurance cost
    public double insurancePremiere() {
        AvailabilityChecker availability = new AvailabilityChecker();
        boolean check = availability.variantCheck(this);
        if (!check) {
            throw new IllegalArgumentException("The Premium variant is not available before that date.");
        } else {
            return InsuranceBilling.insuranceSupportAmount(insuredPet, insuranceVariant);
        }
    }

    // Method to display profile info
    public void displayProfile() {
        System.out.println("Insurance Profile:");
        System.out.println("Owner: " + personName + " " + personFamily);
        System.out.println("Owners Age: " + personAge);
        System.out.println("Address: " + personAddress);
        System.out.println("Insurance Variant: " + insuranceVariant);


        Map<String, Double> insuranceDetails = getInsuranceDetails(insuredPet, insuranceVariant);
        System.out.println("Insurance Support Amount: " + insuranceDetails.get("supportAmount") + " Euro");
        System.out.println("Annual Insurance Premiere: " + insuranceDetails.get("annualPremiere") + " Euro");
        System.out.println("******************************");
    }




}





