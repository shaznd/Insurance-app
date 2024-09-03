package com.example.petInsurance.businesscalculations;

import com.example.petInsurance.model.InsuranceProfile;
import com.example.petInsurance.model.enums.InsuranceVariant;

import java.time.LocalDate;

public class AvailabilityChecker {

  public boolean variantCheck(InsuranceProfile profileObject){

      LocalDate cutoffDate = LocalDate.of(2024, 7, 1);
      if (profileObject.getDateOfIssue().isBefore(cutoffDate) && profileObject.getInsuranceVariant() == InsuranceVariant.PREMIUM) {
          return false;
      } else {
          return true;
      }




  }
}
