package com.jgroup.hexagonal_architecture.app.core.usecases;

import com.jgroup.hexagonal_architecture.app.core.domain.Customer;
import com.jgroup.hexagonal_architecture.app.ports.out.AddressOutputPort;
import com.jgroup.hexagonal_architecture.app.ports.out.CustomerOutputPort;

public class CustomerUsecase {

    private final AddressOutputPort addressOutput;

    private final CustomerOutputPort customerOutput;

    public CustomerUsecase(AddressOutputPort addressOutput, CustomerOutputPort customerOutput) {
        this.addressOutput = addressOutput;
        this.customerOutput = customerOutput;
    }
    public void insertCustomer(Customer customer, String zipCode) {
        var address = addressOutput.findAddressByZipCode(zipCode);
        customer.setAddress(address);
        customerOutput.insertCustomer(customer);


    }
}
