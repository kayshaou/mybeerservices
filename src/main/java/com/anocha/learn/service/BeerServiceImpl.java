package com.anocha.learn.service;

import com.anocha.learn.model.BeerDtoV2;
import com.anocha.learn.model.BeerStyleEnum;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id(beerId).beerStyle(BeerStyleEnum.SAISON.name()).build();
    }

    @Override
    public BeerDtoV2 saveBeer(BeerDtoV2 beerDtoV2) {
        return beerDtoV2;
    }


    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
        
    }

    @Override
    public void deleteById(UUID beerId) {

    }
}
