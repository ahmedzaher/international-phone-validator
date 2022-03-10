package com.example.internationalphonevalidator.services;

import com.example.internationalphonevalidator.dtos.PhoneCountry;
import com.example.internationalphonevalidator.responses.CustomerPhoneResponse;
import com.example.internationalphonevalidator.shared.enums.PhoneNumberState;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

public interface CountryPhoneService {

    List<PhoneCountry> findAllPhoneCountries();

    CustomerPhoneResponse validateCustomerPhone(String phone);

}
