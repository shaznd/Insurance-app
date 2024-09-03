package com.example.petInsurance;

import com.example.petInsurance.businesscalculations.InsuranceBilling;
import com.example.petInsurance.model.enums.DogsRace;
import com.example.petInsurance.model.enums.InsuranceVariant;
import com.example.petInsurance.model.impl.Cat;
import com.example.petInsurance.model.impl.Dog;
import com.example.petInsurance.model.impl.SmallPet;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsuranceBillingTest {

    @Test
    public void insuranceSupportAmountForDog() {

        Dog dog = new Dog(LocalDate.of(2018, 4, 15), "Rex", DogsRace.DACKLE);
        double rexSupportAmount = InsuranceBilling.insuranceSupportAmount(dog, InsuranceVariant.PREMIUM);
        double rexAnualPrimiere = InsuranceBilling.annualInsurancePremiere(dog, InsuranceVariant.PREMIUM);

        //dog= 2500 ,variantFactor = 1.4 ----> 2400*1.4 = 3500 = support amount
        // (ageFactor) 0.28 * (support amoun)t 3500 *  (dogRace) 0.9 = annual to pay = 882

        assertEquals(3500, rexSupportAmount, 0.01);

        assertEquals(882, rexAnualPrimiere, 0.01);
    }

    @Test
    public void insuranceSupportAmountForDog2() {

        Dog dog = new Dog(LocalDate.of(2015, 4, 17), "goofy", DogsRace.BERNHARDINER);
        double goofySupportAmount = InsuranceBilling.insuranceSupportAmount(dog, InsuranceVariant.PREMIUM);
        double goofyAnualPrimiere = InsuranceBilling.annualInsurancePremiere(dog, InsuranceVariant.PREMIUM);

        //dog= 2500 ,variantFactor = 1.4 ----> 2400*1.4 = 3500 = support amount
        // (ageFactor) 0.3 * (support amoun)t 3500 *  (dogRace) 1,1 = annual to pay = 882

        assertEquals(3500, goofySupportAmount, 0.01);

        assertEquals(1155, goofyAnualPrimiere, 0.01);
    }

    @Test
    public void insuranceSupportAmountForDog3() {

        Dog dog = new Dog(LocalDate.of(2022, 4, 17), "Spike", DogsRace.HUSKY);
        double spikeSupportAmount = InsuranceBilling.insuranceSupportAmount(dog, InsuranceVariant.OPTIMAL);
        double spikeAnualPrimiere = InsuranceBilling.annualInsurancePremiere(dog, InsuranceVariant.OPTIMAL);

        //dog= 2500 ,variantFactor = 1.2 ----> 2400*1.2 = 3000 = support amount
        // (ageFactor) 0.25 * (support amoun)t 3000 *  (dogRace) 1  = annual to pay = 750

        assertEquals(3000, spikeSupportAmount, 0.01);

        assertEquals(750, spikeAnualPrimiere, 0.01);
    }


    @Test
    public void InsuranceSupportAmountForCat() {

        Cat cat = new Cat(LocalDate.of(2021, 6, 15), "Tom");


        double tomSupportAmount = InsuranceBilling.insuranceSupportAmount(cat, InsuranceVariant.OPTIMAL);
        double tomAnualPrimiere = InsuranceBilling.annualInsurancePremiere(cat, InsuranceVariant.OPTIMAL);

        // Expected supportAmount = 2000 * 1.2 = 2400
        assertEquals(2400, tomSupportAmount, 0.01);
        // age factor 0.25 * supportamount =2400  -----> =600
        assertEquals( 600, tomAnualPrimiere, 0.01);
    }

    @Test
    public void InsuranceSupportAmountForSmallpet() {

        SmallPet hedgehog = new SmallPet(LocalDate.of(2023, 5, 8));


        double tomSupportAmount = InsuranceBilling.insuranceSupportAmount(hedgehog, InsuranceVariant.COMPACT);
        double tomAnualPrimiere = InsuranceBilling.annualInsurancePremiere(hedgehog, InsuranceVariant.COMPACT);

        // Expected supportAmount = 1000 * 1 =  1000
        assertEquals(1000, tomSupportAmount, 0.01);
        // age factor 0.2 * supportamount =1000  -----> =200
        assertEquals( 200, tomAnualPrimiere, 0.01);
    }


}





