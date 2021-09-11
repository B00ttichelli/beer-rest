package com.guru.beerrest.beerrest.services.v2;

import com.guru.beerrest.beerrest.web.model.v2.BeerDtoV2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServicesV2Impl implements BeerServicesV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return null;
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDtoV2) {
        return null;
    }

    @Override
    public void updateBeer(UUID id, BeerDtoV2 beerDtoV2) {

    }

    @Override
    public void deleteById(UUID beerId) {

    }
}
