package com.jumia.phoneverification.backend.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerTypeTest {


    @InjectMocks
    private CustomerType customerType;

    @BeforeEach
    @DisplayName("Inject Mocks Before EveryMethod")
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


//    @Test
//    @DisplayName("Get Customer Type")
//    public void getCustomerTypeTest() {
//
//        Class customerSearchByState = CustomerSearchByState.class;
//
//        Mockito.when(customerType.getCustomerType(true, null)).thenReturn(customerSearchByState);
//
//
//    }


}
