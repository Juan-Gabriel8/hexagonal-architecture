package com.jgroup.hexagonal_architecture.app.ports.in;

import com.jgroup.hexagonal_architecture.app.core.domain.Customer;

public interface CustomerImputPort {

    void insertCustomer(Customer customer, String zipCode);

    Customer findCustomerById(String id);

    void updateCustomer(Customer customer, String zipCode);

    void deleteCustomer(String id);
}
