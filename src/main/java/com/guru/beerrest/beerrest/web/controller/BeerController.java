package com.guru.beerrest.beerrest.web.controller;

import com.guru.beerrest.beerrest.services.BeerServices;
import com.guru.beerrest.beerrest.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("api/v1/beer")
@RestController
public class BeerController {

    private final BeerServices beerServices;

    public BeerController(BeerServices beerServices) {
        this.beerServices = beerServices;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerServices.getBeerById(beerId), HttpStatus.OK);
    }
}
