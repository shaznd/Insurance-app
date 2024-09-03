package com.example.petInsurance;

import com.example.petInsurance.factories.*;
import com.example.petInsurance.model.enums.DogsRace;
import com.example.petInsurance.model.InsuranceProfile;
import com.example.petInsurance.model.enums.InsuranceVariant;
import com.example.petInsurance.model.impl.Cat;
import com.example.petInsurance.model.impl.Dog;
import com.example.petInsurance.model.impl.SmallPet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class PetInsuranceApplication {

    public static void main(String[] args) {

        System.out.println("hello");

        SpringApplication.run(PetInsuranceApplication.class, args);

        AnimalFactory dogFactory = new DogFactory(DogsRace.HUSKY);
        Dog dog = (Dog) dogFactory.createAnimal(LocalDate.of(2018, 3, 20), "Wolfi");

        InsuranceProfile dogProfile = InsuranceProfileFactory.createInsuranceProfile("Wolfgang", "Amadeus", 30, "Wiener opergasse 2", dog, InsuranceVariant.PREMIUM, LocalDate.of(2024, 7, 28));
        dogProfile.displayProfile();
        ///////////////////////////////

        AnimalFactory dogFactory1 = new DogFactory(DogsRace.DACKLE);
        Dog dog1 = (Dog) dogFactory1.createAnimal(LocalDate.of(2018, 3, 10), "Scooby-Doo");

        InsuranceProfile dog1Profile = InsuranceProfileFactory.createInsuranceProfile("Shaggy", "Zand", 35, "Dogs Bahnhof 8", dog1, InsuranceVariant.PREMIUM, LocalDate.of(2024, 8, 28));
        dog1Profile.displayProfile();

        //////////////////////////////////


        AnimalFactory dogFactory2 = new DogFactory(DogsRace.BERNHARDINER);
        Dog dog2 = (Dog) dogFactory2.createAnimal(LocalDate.of(2018, 6, 15), "Snoop Dog");

        InsuranceProfile dog2Profile = InsuranceProfileFactory.createInsuranceProfile("Deathrow", "Records", 35, " NY straße 21", dog2, InsuranceVariant.PREMIUM, LocalDate.of(2024, 8, 28));
        dog2Profile.displayProfile();

        ////////////////////////////////
        AnimalFactory catFactory = new CatFactory();
        Cat cat = (Cat) catFactory.createAnimal(LocalDate.of(2021, 6, 15), "Tom");

        InsuranceProfile catProfile = InsuranceProfileFactory.createInsuranceProfile("Maggie", "Witch", 35, " Catsburg 34 A ", cat, InsuranceVariant.OPTIMAL, LocalDate.of(2024, 1, 28));
        catProfile.displayProfile();

        ////////////////////////////////
        AnimalFactory hamsterFactory = new SmallPetFactory();
        SmallPet hamster = (SmallPet) hamsterFactory.createAnimal(LocalDate.of(2023, 7, 12), "Ham ham");

        InsuranceProfile hamsterProfile = InsuranceProfileFactory.createInsuranceProfile("Hamataro", "Suzuki", 67, " okinava Sega straße 32", hamster, InsuranceVariant.COMPACT, LocalDate.of(2024, 1, 28));
        hamsterProfile.displayProfile();


        System.out.println("objects without using factory ***********************************");

        Dog dog0 = new Dog(LocalDate.of(2018, 3, 20), "Wolfi", DogsRace.HUSKY);


        InsuranceProfile dog0Profile = new InsuranceProfile("John", "Johnson", 30, "123 Main St", dog0, InsuranceVariant.PREMIUM, LocalDate.of(2024, 11, 18));


    }
}
