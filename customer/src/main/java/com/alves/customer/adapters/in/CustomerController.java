package com.alves.customer.adapters.in;

import com.alves.customer.dto.customer.CustomerRequestDto;
import com.alves.customer.dto.customer.CustomerResponseDto;
import com.alves.customer.mapper.CustomerMapper;
import com.alves.customer.ports.in.CustomerServicePort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerServicePort customerService;
    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    public CustomerController(CustomerServicePort customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody @Valid CustomerRequestDto customerRequestDto) {
        CustomerResponseDto responseDto = customerMapper.toResponseDto(customerService.createCustomer(customerRequestDto));
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable String id) {
        return ResponseEntity.ok(customerMapper.toResponseDto(customerService.getCustomerById(id)));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getCustomers() {
        List<CustomerResponseDto> responseDtoList = customerService.getAllCustomers()
                .stream()
                .map(customerMapper::toResponseDto)
                .toList();

        return ResponseEntity.ok(responseDtoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
