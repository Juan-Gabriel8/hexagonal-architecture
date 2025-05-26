package com.jgroup.hexagonal_architecture.adapters.out;

import com.jgroup.hexagonal_architecture.adapters.out.repositories.CustomerRepository;
import com.jgroup.hexagonal_architecture.adapters.out.repositories.mapper.CustomerEntityMapper;
import com.jgroup.hexagonal_architecture.app.core.domain.Customer;
import com.jgroup.hexagonal_architecture.app.ports.out.CustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerOutputAdapter implements CustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insertCustomer(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }

    @Override
    public Optional<Customer> findCustomerById(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }

    @Override
    public void updateCustomer(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
