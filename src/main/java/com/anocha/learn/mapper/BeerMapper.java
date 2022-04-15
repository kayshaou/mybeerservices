package com.anocha.learn.mapper;

import com.anocha.learn.domain.Beer;
import com.anocha.learn.model.BeerDto;

//@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
