package com.example.internationalphonevalidator.responses;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class CustomerPhoneResponse {

    private String country;

    private String state;

    private String countryCode;

    private String number;

}
