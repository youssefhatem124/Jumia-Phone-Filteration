package com.jumia.phoneverification.backend.service;

import com.jumia.phoneverification.backend.mapper.MapperStruct;
import com.jumia.phoneverification.backend.model.dto.CustomerDtoPage;
import com.jumia.phoneverification.backend.model.entity.Customer;
import com.jumia.phoneverification.backend.repo.CustomerRepo;
import com.jumia.phoneverification.backend.util.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CustomerSearchByStateTest {

    private List<Customer> mockCustomers;

    @InjectMocks
    private CustomerSearchByState customerSearchByState;

    @Mock
    private CustomerRepo mockRepo;

    @Mock
    private Utils utils;

    private  final MapperStruct mapperStruct = MapperStruct.INSTANCE;

    @BeforeEach
    @DisplayName("Inject Mocks Before EveryMethod")
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    @DisplayName("Find By true State")
    public void findByTrueStateTest() {

        Customer customer1 = new Customer(1, "youssef", "(237) 699209115");
        Customer customer2 = new Customer(2, "jumia", "(237) 699209114");
        mockCustomers = new ArrayList<>();
        mockCustomers.add(customer1);
        mockCustomers.add(customer2);

        Page<Customer> page = new PageImpl<>(mockCustomers);

        Mockito.when(mockRepo.findAll()).thenReturn(mockCustomers);

        mockCustomers.stream().forEach(customer ->
                Mockito.when(utils.validateNumber(customer.getPhone())).thenReturn(true));


        CustomerDtoPage actualFilteredCustomer = customerSearchByState.getFilteredCustomer(0, true, null);

        CustomerDtoPage all = mapperStruct.mapEntityPageToDto(page);

        Assertions.assertEquals(all, actualFilteredCustomer, "Should Find filtered Customers by true State");

    }

    @Test
    @DisplayName("Find By false State")
    public void findByFalseStateTest() {

        Customer customer1 = new Customer(1, "youssef", "(237) 699209115");
        Customer customer2 = new Customer(2, "jumia", "(237) 699209114");
        mockCustomers = new ArrayList<>();
        mockCustomers.add(customer1);
        mockCustomers.add(customer2);

        Page<Customer> page = new PageImpl<>(mockCustomers);

        Mockito.when(mockRepo.findAll()).thenReturn(mockCustomers);

        mockCustomers.stream().forEach(customer ->
                Mockito.when(utils.validateNumber(customer.getPhone())).thenReturn(false));


        CustomerDtoPage actualFilteredCustomer = customerSearchByState.getFilteredCustomer(0, false, null);

        CustomerDtoPage all = mapperStruct.mapEntityPageToDto(page);

        Assertions.assertEquals(all, actualFilteredCustomer, "Should Find filtered Customers by false State");

    }


}


