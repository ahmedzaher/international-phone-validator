package com.example.internationalphonevalidator.repositories.specifications;

import com.example.internationalphonevalidator.dtos.CustomerFilter;
import com.example.internationalphonevalidator.entities.Customer;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CustomerSpecification implements Specification<Customer> {

    private static final String _PHONE = "phone";

    private final CustomerFilter customerFilter;

    public CustomerSpecification(CustomerFilter customerFilter) {
        this.customerFilter = customerFilter;
    }

    @Override
    public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();
        if (StringUtils.hasText(customerFilter.getCountryCode())) {
            String phonePattern = "(" + customerFilter.getCountryCode() + ")%";
            predicates.add(
                    criteriaBuilder.like(root.get(_PHONE), phonePattern)
            );
        }

        if (customerFilter.getState() != null) {
            // TODO to be implemented once fix regex validation over sqlite3
            // it supposed to replace the filter in listing response
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
