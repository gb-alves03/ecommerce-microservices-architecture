package com.alves.customer.mapper;

import com.alves.customer.adapters.out.entities.AddressEntity;
import com.alves.customer.adapters.out.entities.CustomerEntity;
import com.alves.customer.domain.Address;
import com.alves.customer.domain.Customer;
import com.alves.customer.dto.customer.CustomerRequestDto;
import com.alves.customer.dto.customer.CustomerResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);


    CustomerEntity toEntity(CustomerRequestDto customerRequestDto);

    CustomerResponseDto toResponseDto(Customer customer);

    Customer toDomain(CustomerEntity customerEntity);

    Customer toDomain(CustomerRequestDto customerRequestDto);

    CustomerEntity toEntity(Customer customer);

    Address toDomain(AddressEntity addressEntity);

    AddressEntity toEntity(Address address);
}