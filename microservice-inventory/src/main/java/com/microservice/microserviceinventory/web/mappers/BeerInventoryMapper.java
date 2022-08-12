package com.microservice.microserviceinventory.web.mappers;

import com.microservice.microserviceinventory.domain.BeerInventory;
import com.microservice.microserviceinventory.web.model.BeerInventoryDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {
    BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDTO);

    BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory);
}
