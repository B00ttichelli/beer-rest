package com.guru.beerrest.beerrest.web.controller;


import com.guru.beerrest.beerrest.services.CustomerService;
import com.guru.beerrest.beerrest.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {


    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId")UUID id){

        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);

    }


    @PostMapping
    public ResponseEntity handlePost( @Valid @RequestBody CustomerDto customerDto){
        CustomerDto saveDto = customerService.saveNewCustomer(customerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        //todo add hostname to url
        httpHeaders.add("Location","/api/v1/customer/"+saveDto.getId().toString());
        return new ResponseEntity(httpHeaders,HttpStatus.CREATED);

    }
    @PutMapping("/{customerId}")
    public ResponseEntity handleUpdate (@PathVariable("customerId") UUID customerId, @Valid @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerId,customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId")UUID customerId){
        customerService.deleteById(customerId);
    }

/*    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler (ConstraintViolationException e){
        List<String> errors = new ArrayList<>();

        e.getConstraintViolations().forEach(constraintViolation -> errors.add(constraintViolation.getPropertyPath() +" : "+constraintViolation.getMessage()));
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }*/
}
