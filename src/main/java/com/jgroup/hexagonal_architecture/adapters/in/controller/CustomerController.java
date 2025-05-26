package com.jgroup.hexagonal_architecture.adapters.in.controller;

import com.jgroup.hexagonal_architecture.adapters.in.controller.mapper.CustomerMapper;
import com.jgroup.hexagonal_architecture.adapters.in.controller.request.CustomerRequest;
import com.jgroup.hexagonal_architecture.adapters.in.controller.response.CustomerResponse;
import com.jgroup.hexagonal_architecture.app.core.domain.Customer;
import com.jgroup.hexagonal_architecture.app.ports.in.CustomerImputPort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerMapper customerMapper;

    private final CustomerImputPort customerImputPort;

    public CustomerController(CustomerMapper customerMapper, CustomerImputPort customerImputPort) {
        this.customerMapper = customerMapper;
        this.customerImputPort = customerImputPort;
    }

    @PostMapping
    public ResponseEntity<Void> insertCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        customerImputPort.insertCustomer(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();

    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        var customer = customerImputPort.findCustomerById(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCustomer(@PathVariable final String id,
                                               @Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        customerImputPort.updateCustomer(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

}
