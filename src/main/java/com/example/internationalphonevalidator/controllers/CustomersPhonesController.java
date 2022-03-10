package com.example.internationalphonevalidator.controllers;

import com.example.internationalphonevalidator.services.CountryPhoneServiceImpl;
import com.example.internationalphonevalidator.services.CustomerServices;
import com.example.internationalphonevalidator.shared.enums.PhoneNumberState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("customers")
public class CustomersPhonesController {

    private final CustomerServices customerServices;
    private final CountryPhoneServiceImpl countryPhoneService;

    @GetMapping("phones")
    public String findAll(
            @RequestParam(required = false) String countryCode,
            @RequestParam(required = false) PhoneNumberState state,
            Model model) {
        model.addAttribute("customerPhones", customerServices.findCustomerPhones(countryCode, state));
        model.addAttribute("phoneCountries", countryPhoneService.findAllPhoneCountries());
        return "customers/phones/index";
    }

}
