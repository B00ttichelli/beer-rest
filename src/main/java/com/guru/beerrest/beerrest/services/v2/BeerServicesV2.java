package com.guru.beerrest.beerrest.services.v2;

import com.guru.beerrest.beerrest.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServicesV2 {
    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 saveNewBeer(BeerDtoV2 beerDtoV2);

    void updateBeer(UUID id,BeerDtoV2 beerDtoV2);

    void deleteById(UUID beerId);
}
