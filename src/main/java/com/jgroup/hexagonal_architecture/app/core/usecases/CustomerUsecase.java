package com.jgroup.hexagonal_architecture.app.core.usecases;

import com.jgroup.hexagonal_architecture.app.core.domain.Customer;
import com.jgroup.hexagonal_architecture.app.ports.in.CustomerImputPort;
import com.jgroup.hexagonal_architecture.app.ports.out.AddressOutputPort;
import com.jgroup.hexagonal_architecture.app.ports.out.CustomerOutputPort;
import com.jgroup.hexagonal_architecture.app.ports.out.SendCpfForValidationOutputPort;

public class CustomerUsecase implements CustomerImputPort {

    private final AddressOutputPort addressOutput;

    private final CustomerOutputPort customerOutput;

    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public CustomerUsecase(AddressOutputPort addressOutput, CustomerOutputPort customerOutput, SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.addressOutput = addressOutput;
        this.customerOutput = customerOutput;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insertCustomer(Customer customer, String zipCode) {
        var address = addressOutput.findAddressByZipCode(zipCode);
        customer.setAddress(address);
        customerOutput.insertCustomer(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());
    }

    @Override
    public Customer findCustomerById(String id) {
        return customerOutput.findCustomerById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public void updateCustomer(Customer customer, String zipCode) {
        findCustomerById(customer.getId());
        var address = addressOutput.findAddressByZipCode(zipCode);
        customer.setAddress(address);
        customerOutput.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        findCustomerById(id);
        customerOutput.deleteCustomer(id);

    }

}
