package com.guru.beerrest.beerrest.services;

import com.guru.beerrest.beerrest.web.model.BeerDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class BeerServicesImpl implements BeerServices {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID()).beerName("GalaxyCat").beerStyle("Pale Ale").build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID()).build();
    }
}
