package com.guru.beerrest.beerrest.web.controller;

import com.guru.beerrest.beerrest.services.BeerServices;
import com.guru.beerrest.beerrest.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v1/beer")
@RestController
public class BeerController {

    private final BeerServices beerServices;

    public BeerController(BeerServices beerServices) {
        this.beerServices = beerServices;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerServices.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity handlePost(BeerDto beerDto) {
        BeerDto saveDTO = beerServices.saveNewBeer(beerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        //todo add hostname to url
        httpHeaders.add("Location","/api/v1/beer/" + saveDTO.getId().toString());
        return new ResponseEntity(httpHeaders,HttpStatus.CREATED);
    }
}
