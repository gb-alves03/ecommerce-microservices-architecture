package com.alves.customer.adapters.out.repository;

import com.alves.customer.adapters.out.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataCustomerRepository extends JpaRepository<CustomerEntity, UUID> {
}
