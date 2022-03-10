package com.example.internationalphonevalidator.services;

import com.example.internationalphonevalidator.dtos.PhoneCountry;
import com.example.internationalphonevalidator.responses.CustomerPhoneResponse;
import com.example.internationalphonevalidator.shared.enums.PhoneNumberState;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class CountryPhoneServiceImpl implements CountryPhoneService {

    private List<PhoneCountry> phonesCountries;
    private final ObjectMapper objectMapper;
    private final String countriesPath;

    public CountryPhoneServiceImpl(ObjectMapper objectMapper, @Value("${countries.data.path}") String countriesPath) {
        this.objectMapper = objectMapper;
        this.countriesPath = countriesPath;
        this.loadPhoneCountries();
    }

    @Override
    public List<PhoneCountry> findAllPhoneCountries() {
        return this.phonesCountries;
    }

    @Override
    public CustomerPhoneResponse validateCustomerPhone(String phone) {
        CustomerPhoneResponse response = new CustomerPhoneResponse(phone);
        for (PhoneCountry phoneCountry : this.phonesCountries) {
            if (isValidCountryCode(phone, phoneCountry.getCode())) {
                response.setCountry(phoneCountry.getName());
                response.setCountryCode("+" + phoneCountry.getCode());
                if (isValidCountryNumber(phone, phoneCountry.getRegex())) {
                    response.setState(PhoneNumberState.VALID.getValue());
                }
                break;
            }
        }

        return response;
    }

    private boolean isValidCountryCode(String phone, String countryCode) {
        String countryPhoneCodeRegex = "^\\(" + countryCode + "\\).*";
        return Pattern.compile(countryPhoneCodeRegex).matcher(phone).matches();
    }

    private boolean isValidCountryNumber(String phone, String countryRegex) {
        return Pattern.compile(countryRegex).matcher(phone).matches();
    }

    @SneakyThrows
    private void loadPhoneCountries() {
        this.phonesCountries = objectMapper.readValue(new ClassPathResource(countriesPath).getInputStream(),
                new TypeReference<List<PhoneCountry>>() {
        });
    }
}
