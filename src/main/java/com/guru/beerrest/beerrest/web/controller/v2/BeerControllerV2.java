package com.guru.beerrest.beerrest.web.controller.v2;


import com.guru.beerrest.beerrest.services.BeerServices;
import com.guru.beerrest.beerrest.services.v2.BeerServicesV2;
import com.guru.beerrest.beerrest.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServicesV2 beerServices;

    public BeerControllerV2(BeerServicesV2 beerServices) {
        this.beerServices = beerServices;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerServices.getBeerById(beerId), HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity handlePost(@Valid @RequestBody BeerDtoV2 beerDtoV2){
        BeerDtoV2 saveDto = beerServices.saveNewBeer(beerDtoV2);
        HttpHeaders httpHeaders = new HttpHeaders();
        //todo hostname to url
        httpHeaders.add("Location","/api/v2/beer" +saveDto.getId().toString());
        return new ResponseEntity(httpHeaders,HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable("beerId") UUID id, @Valid @RequestBody BeerDtoV2 beerDtoV2){
        beerServices.updateBeer(id,beerDtoV2);
    }


    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){

        beerServices.deleteById(beerId);
    }

/*    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e){
        List<String> errors = new ArrayList<>();

        e.getConstraintViolations().forEach(constraintViolation -> errors.add(constraintViolation.getPropertyPath()+
                ":" + constraintViolation.getMessage()));
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }*/

}
