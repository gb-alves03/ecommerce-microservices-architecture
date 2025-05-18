package com.alves.customer.adapters.out.repository;

import com.alves.customer.adapters.out.entities.CustomerEntity;
import com.alves.customer.domain.Customer;
import com.alves.customer.dto.customer.CustomerRequestDto;
import com.alves.customer.mapper.CustomerMapper;
import com.alves.customer.ports.out.CustomerRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class JpaCustomerRepository implements CustomerRepositoryPort {

    private final SpringDataCustomerRepository customerRepository;
    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    public JpaCustomerRepository(SpringDataCustomerRepository springDataCustomerRepository) {
        this.customerRepository = springDataCustomerRepository;
    }


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(UUID.fromString(id))
                .map(customerMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Customer save(CustomerRequestDto customerRequestDto) {
        CustomerEntity customerEntity = customerMapper.toEntity(customerRequestDto);
        return customerMapper.toDomain(customerRepository.save(customerEntity));
    }

    @Override
    public void deleteById(String id) {
        customerRepository.deleteById(UUID.fromString(id));
    }
}
