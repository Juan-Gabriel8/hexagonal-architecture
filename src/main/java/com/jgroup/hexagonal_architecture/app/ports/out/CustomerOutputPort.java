package com.jgroup.hexagonal_architecture.app.ports.out;

import com.jgroup.hexagonal_architecture.app.core.domain.Customer;

public interface CustomerOutputPort {

    void insertCustomer(Customer customer);
}
