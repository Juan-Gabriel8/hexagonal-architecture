package com.jgroup.hexagonal_architecture.app.ports.out;

import com.jgroup.hexagonal_architecture.app.core.domain.Customer;

import java.util.Optional;

public interface CustomerOutputPort {

    void insertCustomer(Customer customer);

    Optional<Customer> findCustomerById(String id);

    void updateCustomer(Customer customer);

    void deleteCustomer(String id);
}
