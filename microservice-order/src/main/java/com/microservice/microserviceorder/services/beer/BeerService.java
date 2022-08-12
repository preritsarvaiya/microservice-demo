package com.microservice.microserviceorder.services.beer;

import com.microservice.microserviceorder.web.model.BeerDto;

import java.util.Optional;
import java.util.UUID;

public interface BeerService {
    Optional<BeerDto> getBeerById(UUID id);

    Optional<BeerDto> getBeerByUpc(String upc);
}
