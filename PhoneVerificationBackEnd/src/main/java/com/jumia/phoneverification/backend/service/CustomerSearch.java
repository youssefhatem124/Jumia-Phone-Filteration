package com.jumia.phoneverification.backend.service;

import com.jumia.phoneverification.backend.model.dto.CustomerDtoPage;
import com.jumia.phoneverification.backend.repo.CustomerRepo;
import com.jumia.phoneverification.backend.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CustomerSearch {

    protected static final int DEFAULT_PAGE_SIZE = 10;

    @Autowired
    protected CustomerRepo customerRepo;
    @Autowired
    protected Utils utils;

    public abstract CustomerDtoPage getFilteredCustomer(int pageNumber, Boolean state, String country);
}
