package br.com.alves.ecommerce.authentication.dto.user;

import br.com.alves.ecommerce.authentication.enums.RoleName;

public record UserRequestDto(
        String email,
        String password,
        RoleName role
) {
}
