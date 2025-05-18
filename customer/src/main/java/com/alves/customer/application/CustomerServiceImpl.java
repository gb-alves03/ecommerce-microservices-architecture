package com.alves.customer.application;

import com.alves.customer.domain.Customer;
import com.alves.customer.dto.customer.CustomerRequestDto;
import com.alves.customer.mapper.CustomerMapper;
import com.alves.customer.ports.in.CustomerServicePort;
import com.alves.customer.ports.out.CustomerRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerServicePort {

    private final CustomerRepositoryPort customerRepository;
    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    public CustomerServiceImpl(CustomerRepositoryPort customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer createCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = customerMapper.toDomain(customerRequestDto);
        customer.setCreatedAt(LocalDateTime.now());
       return customerRepository.save(customerRequestDto);

    }

    @Override
    public Customer getCustomerById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(String id, CustomerRequestDto customerRequestDto) {
        return null;
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }
}
