package br.com.alves.ecommerce.authentication.controller;

import br.com.alves.ecommerce.authentication.dto.auth.LoginUserDto;
import br.com.alves.ecommerce.authentication.dto.auth.RecoveryJwtTokenDto;
import br.com.alves.ecommerce.authentication.dto.user.UserRequestDto;
import br.com.alves.ecommerce.authentication.dto.user.UserResponseDto;
import br.com.alves.ecommerce.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<RecoveryJwtTokenDto> authenticateUser(@RequestBody LoginUserDto loginUserDto) {
        RecoveryJwtTokenDto token = userService.authenticateUser(loginUserDto);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserRequestDto userRequestDto) {
        userService.createUser(userRequestDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public ResponseEntity<String> getAuthenticationTest() {
        return new ResponseEntity<>("Authenticated with success", HttpStatus.OK);
    }

    @GetMapping("/test/customer")
    public ResponseEntity<String> getCustomerAuthenticationTest() {
        return new ResponseEntity<>("Client authenticated with success", HttpStatus.OK);
    }

    @GetMapping("/test/administrator")
    public ResponseEntity<String> getAdminAuthenticationTest() {
        return new ResponseEntity<>("Administrator authenticated with success", HttpStatus.OK);
    }
}
