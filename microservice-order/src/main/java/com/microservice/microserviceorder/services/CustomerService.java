package com.microservice.microserviceorder.services;

import com.microservice.microserviceorder.web.model.CustomerPagedList;
import org.springframework.data.domain.PageRequest;

public interface CustomerService {
    CustomerPagedList listCustomers(PageRequest pageable);
}
