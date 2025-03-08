package com.alves.customer.ports.in;

import com.alves.customer.domain.Customer;
import com.alves.customer.dto.customer.CustomerRequestDto;

import java.util.List;

public interface CustomerServicePort {
    Customer createCustomer(CustomerRequestDto customerRequestDto);
    Customer getCustomerById(String id);
    List<Customer> getAllCustomers();
    Customer updateCustomer(String id, CustomerRequestDto customerRequestDto);
    void deleteCustomer(String id);

}
