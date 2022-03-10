package com.example.internationalphonevalidator.dtos;

import lombok.Data;

@Data
public class CountryCheckResult {

    private String countryName;
    private String countryCode;
    private String state;
}
