package com.jumia.phoneverification.backend.service.mapper;

import com.jumia.phoneverification.backend.mapper.MapperStruct;
import com.jumia.phoneverification.backend.model.dto.CustomerDto;
import com.jumia.phoneverification.backend.model.dto.CustomerDtoPage;
import com.jumia.phoneverification.backend.model.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapperStructTest {

    private List<Customer> mockCustomers;


    @Test
    void shouldConvertEntityToDto() {
        Customer customer1 = new Customer(1, "youssef", "(237) 699209115");
        final CustomerDto customerResponse = MapperStruct.INSTANCE.entityToDto(customer1);

        assertEquals(customer1.getName(), customerResponse.getName());
        assertEquals(customer1.getPhone(), customerResponse.getPhone());
    }

    @Test
    void shouldConvertEntityPageToDto() {
        Customer customer1 = new Customer(1, "youssef", "(237) 699209115");
        Customer customer2 = new Customer(2, "jumia", "(237) 699209114");

        mockCustomers = new ArrayList<>();
        mockCustomers.add(customer1);
        mockCustomers.add(customer2);

        Page<Customer> page = new PageImpl<>(mockCustomers);
        CustomerDtoPage customerResponse = MapperStruct.INSTANCE.mapEntityPageToDto(page);

        Assertions.assertIterableEquals(page.toList().stream().map(MapperStruct.INSTANCE::entityToDto).collect(toList()), customerResponse.getCustomerDtoList());
        assertEquals(page.getTotalPages(), customerResponse.getNumberOfPages());
    }



}
