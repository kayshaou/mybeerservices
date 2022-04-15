package com.anocha.learn.service;

import com.anocha.learn.model.BeerDtoV2;

import java.util.UUID;


public interface BeerService {
    
    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 saveBeer(BeerDtoV2 beerDtoV2);

    public void updateBeer(UUID beerId, BeerDtoV2 beerDto);

    public void deleteById(UUID beerId);
}

