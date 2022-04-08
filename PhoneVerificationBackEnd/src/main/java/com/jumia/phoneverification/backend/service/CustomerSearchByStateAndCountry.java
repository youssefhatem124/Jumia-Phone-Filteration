package com.jumia.phoneverification.backend.service;

import com.jumia.phoneverification.backend.mapper.MapperStruct;
import com.jumia.phoneverification.backend.model.dto.CustomerDtoPage;
import com.jumia.phoneverification.backend.model.entity.Customer;
import com.jumia.phoneverification.backend.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Service
public class CustomerSearchByStateAndCountry extends CustomerSearch {

    @Autowired
    private Utils utils;

    @Override
    public CustomerDtoPage getFilteredCustomer(int pageNumber, Boolean state, String country) {

        String countryCode = utils.getCountryCodeBasedOnCountry(country);

        List<Customer> customerListBeforePagination = customerRepo.findByPhoneContaining(countryCode).stream()
                .filter(customer -> utils.validateNumber(customer.getPhone()) == state)
                .collect(toList());
        return MapperStruct.INSTANCE.getCustomerDtoPage(customerListBeforePagination, pageNumber);

    }
}





