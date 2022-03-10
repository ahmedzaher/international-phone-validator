package com.example.internationalphonevalidator.services;

import com.example.internationalphonevalidator.dtos.CustomerFilter;
import com.example.internationalphonevalidator.entities.Customer;
import com.example.internationalphonevalidator.repositories.CustomerRepository;
import com.example.internationalphonevalidator.repositories.specifications.CustomerSpecification;
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
public class CustomerServicesImpl implements CustomerServices {

    private final CustomerRepository customerRepository;
    private final CountryPhoneServiceImpl countryPhoneService;

    @Override
    public List<CustomerPhoneResponse> findCustomerPhones(String countryCode, PhoneNumberState state) {
        CustomerFilter filter = new CustomerFilter(countryCode, state);
        CustomerSpecification customerSpecification = new CustomerSpecification(filter);
        List<Customer> customers = customerRepository.findAll(customerSpecification);
        return customers.stream().map(this::mapToCustomerPhoneResponse).filter(
                x ->  {
                    if(state != null) {
                        return state.getValue().equals(x.getState());
                    }
                    return true;
                }
        ).collect(Collectors.toList());
    }


    private CustomerPhoneResponse mapToCustomerPhoneResponse(Customer customer) {
        CustomerPhoneResponse response = countryPhoneService.validateCustomerPhone(customer.getPhone());
        response.setName(customer.getName());
        return response;
    }
}
