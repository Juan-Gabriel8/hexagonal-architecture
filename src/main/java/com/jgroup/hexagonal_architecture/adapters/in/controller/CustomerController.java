package com.jgroup.hexagonal_architecture.adapters.in.controller;

import com.jgroup.hexagonal_architecture.adapters.in.controller.mapper.CustomerMapper;
import com.jgroup.hexagonal_architecture.adapters.in.controller.request.CustomerRequest;
import com.jgroup.hexagonal_architecture.app.ports.in.CustomerImputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerRequest customerRequest;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerImputPort customerImputPort;

    public ResponseEntity<Void> insertCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        customerImputPort.insertCustomer(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();

    }
}
