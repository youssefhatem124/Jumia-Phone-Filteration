package com.jumia.phoneverification.backend.controller;

import com.jumia.phoneverification.backend.model.dto.CustomerDtoPage;
import com.jumia.phoneverification.backend.service.CustomerSearch;
import com.jumia.phoneverification.backend.service.CustomerType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping(value = "/jumia")
public class CustomersController {

    @Autowired
    private final CustomerType customerType;

    @GetMapping("/customers")
    public CustomerDtoPage getCustomers(@RequestParam int pageNumber, @RequestParam(required = false) Boolean state, @RequestParam(required = false) String country) {
        CustomerSearch customerSearch = customerType.getCustomerType(state, country);
        return customerSearch.getFilteredCustomer(pageNumber, state, country);
    }
}
