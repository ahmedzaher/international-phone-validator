package com.example.internationalphonevalidator.services;

import com.example.internationalphonevalidator.responses.CustomerPhoneResponse;
import com.example.internationalphonevalidator.shared.enums.GlobalMessage;
import com.example.internationalphonevalidator.shared.enums.PhoneNumberState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryPhoneServiceTests {

    @Autowired
    private CountryPhoneService countryPhoneService;

    private static final String MOROCCO = "Morocco";

    @Test
    void testValidateCustomerPhoneGivenValidMoroccoThenStateValid() {

        final CustomerPhoneResponse result = countryPhoneService.validateCustomerPhone("(212) 698054317");
        Assertions.assertEquals(PhoneNumberState.VALID.getValue(), result.getState());
        Assertions.assertEquals(MOROCCO, result.getCountry());
    }

    @Test
    void testValidateCustomerPhoneGivenInValidMoroccoThenStateInvalid() {

        final CustomerPhoneResponse result = countryPhoneService.validateCustomerPhone("(212) 6007989253");
        Assertions.assertEquals(PhoneNumberState.INVALID.getValue(), result.getState());
        Assertions.assertEquals(MOROCCO, result.getCountry());
    }

    @Test
    void testValidateCustomerPhoneGivenInValidPhoneThenStateInvalid() {

        final CustomerPhoneResponse result = countryPhoneService.validateCustomerPhone("(xyz) abc");
        Assertions.assertEquals(PhoneNumberState.INVALID.getValue(), result.getState());
        Assertions.assertEquals(GlobalMessage.UNKNOWN.getValue(), result.getCountry());
    }
}
