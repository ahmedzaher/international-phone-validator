package com.example.internationalphonevalidator.repositories;

import com.example.internationalphonevalidator.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    
}
