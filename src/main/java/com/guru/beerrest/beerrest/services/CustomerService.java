package com.guru.beerrest.beerrest.services;

import com.guru.beerrest.beerrest.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID id);
}
