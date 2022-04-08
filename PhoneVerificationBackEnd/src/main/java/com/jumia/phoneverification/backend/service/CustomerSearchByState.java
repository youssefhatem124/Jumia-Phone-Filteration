package com.jumia.phoneverification.backend.service;

import com.jumia.phoneverification.backend.mapper.MapperStruct;
import com.jumia.phoneverification.backend.model.dto.CustomerDtoPage;
import com.jumia.phoneverification.backend.model.entity.Customer;
import org.springframework.stereotype.Service;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CustomerSearchByState extends CustomerSearch {

    @Override
    public CustomerDtoPage getFilteredCustomer(int pageNumber, Boolean state, String country) {
        List<Customer> customerListBeforePagination = customerRepo.findAll().stream()
                .filter(customer -> utils.validateNumber(customer.getPhone()) == state).collect(toList());
        return MapperStruct.INSTANCE.getCustomerDtoPage(customerListBeforePagination, pageNumber);
    }

}

