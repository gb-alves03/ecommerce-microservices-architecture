package br.com.alves.ecommerce.authentication.dto.auth;

import br.com.alves.ecommerce.authentication.domain.util.Role;

import java.util.List;
import java.util.UUID;

public record RecoveryUserDto(
        UUID id,
        String email,
        List<Role> roles
) {
}
