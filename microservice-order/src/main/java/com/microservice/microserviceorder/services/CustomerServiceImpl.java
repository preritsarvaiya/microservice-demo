package com.microservice.microserviceorder.services;

import com.microservice.microserviceorder.domain.Customer;
import com.microservice.microserviceorder.repositories.CustomerRepository;
import com.microservice.microserviceorder.web.mappers.CustomerMapper;
import com.microservice.microserviceorder.web.model.CustomerPagedList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerPagedList listCustomers(PageRequest pageable) {
        Page<Customer> customerPage = customerRepository.findAll(pageable);

        return new CustomerPagedList(customerPage.stream().map(customerMapper::customerDto)
                .collect(Collectors.toList()), PageRequest.of(customerPage.getPageable().getPageNumber(),
                customerPage.getPageable().getPageSize()), customerPage.getTotalElements());
    }
}
