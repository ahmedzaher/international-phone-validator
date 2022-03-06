package com.example.internationalphonevalidator.controllers;

import com.example.internationalphonevalidator.repositories.CustomerRepository;
import com.example.internationalphonevalidator.services.CustomerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("customers")
public class CustomersPhonesController {

    private final CustomerServices customerServices;

    @GetMapping("phones")
    public String findAll(Model model) {
        model.addAttribute("customerPhones", customerServices.findCustomerPhones());
        return "customers/phones/index";
    }

}
