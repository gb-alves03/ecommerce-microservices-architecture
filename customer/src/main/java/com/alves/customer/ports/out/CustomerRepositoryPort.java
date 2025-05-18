package com.alves.customer.ports.out;

import com.alves.customer.domain.Customer;
import com.alves.customer.dto.customer.CustomerRequestDto;

import java.util.List;

public interface CustomerRepositoryPort {
    List<Customer> findAll();
    Customer findById(String id);
    Customer save(CustomerRequestDto customerRequestDto);
    void deleteById(String id);
}
