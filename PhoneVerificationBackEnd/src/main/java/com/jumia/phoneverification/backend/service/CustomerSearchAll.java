package com.jumia.phoneverification.backend.service;

import com.jumia.phoneverification.backend.mapper.MapperStruct;
import com.jumia.phoneverification.backend.model.dto.CustomerDtoPage;
import com.jumia.phoneverification.backend.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerSearchAll extends CustomerSearch {


    public CustomerDtoPage getFilteredCustomer(int pageNumber, Boolean state, String country) {
        PageRequest pageRequest = PageRequest.of(pageNumber, DEFAULT_PAGE_SIZE);
        Page<Customer> all = customerRepo.findAll(pageRequest);
        return MapperStruct.INSTANCE.mapEntityPageToDto(all);
    }

}



