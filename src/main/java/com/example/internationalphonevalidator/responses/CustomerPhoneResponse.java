package com.example.internationalphonevalidator.responses;

import com.example.internationalphonevalidator.shared.enums.GlobalMessage;
import com.example.internationalphonevalidator.shared.enums.PhoneNumberState;
import lombok.Data;

@Data
public class CustomerPhoneResponse {

    private String name;

    private String country;

    private String state;

    private String countryCode;

    private String number;

    public CustomerPhoneResponse(String number) {
        this.number = number;
        this.setCountry(GlobalMessage.UNKNOWN.getValue());
        this.setCountryCode(GlobalMessage.UNKNOWN.getValue());
        this.setState(PhoneNumberState.INVALID.getValue());
    }
}
