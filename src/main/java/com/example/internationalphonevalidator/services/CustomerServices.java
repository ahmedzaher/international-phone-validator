package com.example.internationalphonevalidator.services;

import com.example.internationalphonevalidator.responses.CustomerPhoneResponse;
import com.example.internationalphonevalidator.shared.enums.PhoneNumberState;

import java.util.List;


public interface CustomerServices {

    List<CustomerPhoneResponse> findCustomerPhones(String countryCode, PhoneNumberState state);
}
