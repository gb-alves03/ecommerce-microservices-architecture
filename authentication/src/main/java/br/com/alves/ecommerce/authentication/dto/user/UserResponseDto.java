package br.com.alves.ecommerce.authentication.dto.user;

import br.com.alves.ecommerce.authentication.domain.User;
import br.com.alves.ecommerce.authentication.enums.RoleName;

import java.util.UUID;

public record UserResponseDto (
        UUID id,
        String email,
        String password,
        RoleName role
) {
    public UserResponseDto(User user) {
        this(user.getId(), user.getEmail(), user.getPassword(), user.getRoles().get(0).getName());
    }
}
