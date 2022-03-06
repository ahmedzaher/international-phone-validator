package com.example.internationalphonevalidator.services;

import com.example.internationalphonevalidator.entities.Customer;
import com.example.internationalphonevalidator.repositories.CustomerRepository;
import com.example.internationalphonevalidator.responses.CustomerPhoneResponse;
import com.example.internationalphonevalidator.shared.enums.PhoneNumberState;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerServices {

    private final CustomerRepository customerRepository;

    public List<CustomerPhoneResponse> findCustomerPhones() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(this::mapToCustomerPhoneResponse).collect(Collectors.toList());
    }

    private CustomerPhoneResponse mapToCustomerPhoneResponse(Customer customer) {
        return CustomerPhoneResponse.builder()
                .number(customer.getPhone())
                .state(PhoneNumberState.VALID.getValue()) // TODO
                .country("Egypt") //TODO
                .countryCode("+237") //TODO
                .build();
    }
}
