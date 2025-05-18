package com.alves.customer.dto.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressResponseDto {

    private Long id;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String number;
    private String complement;
}
