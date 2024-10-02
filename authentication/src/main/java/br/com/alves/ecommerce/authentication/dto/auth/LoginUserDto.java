package br.com.alves.ecommerce.authentication.dto.auth;

public record LoginUserDto(
        String email,
        String password
) {
}
