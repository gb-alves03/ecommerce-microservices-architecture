package br.com.alves.ecommerce.authentication.service;

import br.com.alves.ecommerce.authentication.config.security.JwtTokenService;
import br.com.alves.ecommerce.authentication.config.security.SecurityConfiguration;
import br.com.alves.ecommerce.authentication.domain.User;
import br.com.alves.ecommerce.authentication.domain.util.Role;
import br.com.alves.ecommerce.authentication.domain.util.UserDetailsImpl;
import br.com.alves.ecommerce.authentication.dto.auth.LoginUserDto;
import br.com.alves.ecommerce.authentication.dto.auth.RecoveryJwtTokenDto;
import br.com.alves.ecommerce.authentication.dto.user.UserRequestDto;
import br.com.alves.ecommerce.authentication.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService tokenService;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    public RecoveryJwtTokenDto authenticateUser(LoginUserDto loginUser) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser.email(), loginUser.password());

        var authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return new RecoveryJwtTokenDto(tokenService.generateToken(userDetails));
    }

    public void createUser(UserRequestDto userRequestDto) {

        User newUser = User.builder()
                .email(userRequestDto.email())
                .password(securityConfiguration.passwordEncoder().encode(userRequestDto.password()))
                .roles(List.of(Role.builder().name(userRequestDto.role()).build()))
                .build();

        userRepository.save(newUser);
    }
}
