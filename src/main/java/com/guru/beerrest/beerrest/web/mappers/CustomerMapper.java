package com.guru.beerrest.beerrest.web.mappers;

import com.guru.beerrest.beerrest.domain.Customer;
import com.guru.beerrest.beerrest.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDto customerDto);

}
