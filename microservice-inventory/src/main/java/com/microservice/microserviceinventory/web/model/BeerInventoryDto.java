package com.microservice.microserviceinventory.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerInventoryDto {
    private UUID id;
    private OffsetDateTime createdTime;
    private OffsetDateTime lastModifiedTime;
    private UUID beerId;
    private Integer quantityOnHand;
}
