package com.example.internationalphonevalidator.dtos;

import com.example.internationalphonevalidator.shared.enums.PhoneNumberState;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerFilter {

    private String countryCode;

    private PhoneNumberState state;

    public CustomerFilter(String countryCode, PhoneNumberState state) {
        this.countryCode = countryCode;
        this.state = state;
    }
}
