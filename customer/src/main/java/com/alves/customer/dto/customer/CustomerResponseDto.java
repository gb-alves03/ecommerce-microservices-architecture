package com.alves.customer.dto.customer;

import com.alves.customer.domain.Address;
import com.alves.customer.dto.address.AddressResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerResponseDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String document;
    private String email;
    private String phone;
    private Address address;
    private LocalDateTime createdAt;
}
