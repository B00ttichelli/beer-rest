package com.guru.beerrest.beerrest.services;

import com.guru.beerrest.beerrest.web.model.BeerDto;

import java.util.UUID;

public interface BeerServices {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);
}
