package com.guru.beerrest.beerrest.web.mappers;

import com.guru.beerrest.beerrest.domain.Beer;
import com.guru.beerrest.beerrest.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    BeerDto beerToBeerDTO(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
