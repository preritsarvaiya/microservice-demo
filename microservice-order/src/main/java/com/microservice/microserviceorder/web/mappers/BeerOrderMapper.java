package com.microservice.microserviceorder.web.mappers;

import com.microservice.microserviceorder.domain.BeerOrder;
import com.microservice.microserviceorder.web.model.BeerOrderDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class, BeerOrderLineMapper.class})
public interface BeerOrderMapper {

    BeerOrderDto beerOrderToDto(BeerOrder beerOrder);

    BeerOrder dtoToBeerOrder(BeerOrderDto dto);
}