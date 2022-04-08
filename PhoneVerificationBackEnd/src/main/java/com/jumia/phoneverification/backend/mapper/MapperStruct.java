package com.jumia.phoneverification.backend.mapper;

import com.jumia.phoneverification.backend.model.dto.CustomerDto;
import com.jumia.phoneverification.backend.model.dto.CustomerDtoPage;
import com.jumia.phoneverification.backend.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Mapper
public interface MapperStruct {
    MapperStruct INSTANCE = Mappers.getMapper(MapperStruct.class);
    int DEFAULT_PAGE_SIZE = 10;

    CustomerDto entityToDto(Customer customer);

    default CustomerDtoPage mapEntityPageToDto(Page<Customer> all) {
        CustomerDtoPage customerDtoPage = new CustomerDtoPage();
        customerDtoPage.setNumberOfPages(all.getTotalPages());
        customerDtoPage.setCustomerDtoList(all.toList().stream().map(MapperStruct.INSTANCE::entityToDto).collect(toList()));
        return customerDtoPage;
    }

    default CustomerDtoPage getCustomerDtoPage(List<Customer> customerListBeforePagination, int pageNumber) {
        int numberOfPages = (int) Math.ceil((double) customerListBeforePagination.size() / DEFAULT_PAGE_SIZE);
        List<Customer> customerList = customerListBeforePagination.stream().skip((long) pageNumber * DEFAULT_PAGE_SIZE).limit(DEFAULT_PAGE_SIZE).collect(toList());
        CustomerDtoPage customerDtoPage = new CustomerDtoPage();
        customerDtoPage.setNumberOfPages(numberOfPages);
        customerDtoPage.setCustomerDtoList(customerList.stream().map(MapperStruct.INSTANCE::entityToDto).collect(toList()));
        return customerDtoPage;
    }

}