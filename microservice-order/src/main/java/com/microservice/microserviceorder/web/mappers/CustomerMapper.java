package com.microservice.microserviceorder.web.mappers;

import com.microservice.microserviceorder.domain.Customer;
import com.microservice.microserviceorder.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface CustomerMapper {
    CustomerDto customerDto(Customer customer);

    Customer dtoToCustomer(Customer dto);
}
