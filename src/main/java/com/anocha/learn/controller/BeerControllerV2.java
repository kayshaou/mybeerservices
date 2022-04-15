package com.anocha.learn.controller;

import com.anocha.learn.model.BeerDtoV2;
import com.anocha.learn.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.UUID;

import static com.anocha.learn.config.BeerConstants.BEER_ENDPOINT_V2;

@RequestMapping(BEER_ENDPOINT_V2)
@RestController
@ComponentScan("com.anocha.learn")
public class BeerControllerV2 {

    @Autowired
    BeerService v2;

    @GetMapping("{beerId}")
    public ResponseEntity<BeerDtoV2> getBeerById(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<BeerDtoV2>(v2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@Valid @RequestBody BeerDtoV2 beerV2) {
        BeerDtoV2 beerDtoV2 = v2.saveBeer(beerV2);
        HttpHeaders header = new HttpHeaders();
        header.add("Location", BEER_ENDPOINT_V2 + beerDtoV2.getId().toString());
        return new ResponseEntity(header, HttpStatus.CREATED);
    }

    @PutMapping("{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity handleUpdate(@Valid @RequestBody BeerDtoV2 beerV2, @PathVariable("beerId") UUID beerId) {
        v2.updateBeer(beerId, beerV2);
        return new ResponseEntity(beerV2, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("beerId") UUID beerId) {
        v2.deleteById(beerId);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }


//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e) {
//        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
//
//        e.getConstraintViolations().forEach(constraintViolation -> {
//            errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
//        });
//
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }

}
