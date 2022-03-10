package com.example.internationalphonevalidator.controllers;

import com.example.internationalphonevalidator.dtos.PhoneCountry;
import com.example.internationalphonevalidator.services.CountryPhoneServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CountryPhonesController {

    private final CountryPhoneServiceImpl countryPhoneService;

    public ResponseEntity<List<PhoneCountry>>findAllPhoneCountries() {
        return ResponseEntity.ok(countryPhoneService.findAllPhoneCountries());
    }
}
