package com.jgroup.hexagonal_architecture.adapters.out;

import com.jgroup.hexagonal_architecture.adapters.out.client.AddressClient;
import com.jgroup.hexagonal_architecture.adapters.out.client.mapper.AddressResponseMapper;
import com.jgroup.hexagonal_architecture.adapters.out.client.response.AddressResponse;
import com.jgroup.hexagonal_architecture.app.core.domain.Address;
import com.jgroup.hexagonal_architecture.app.ports.out.AddressOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressOutputAdapter implements AddressOutputPort {

    @Autowired
    private AddressClient addressClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address findAddressByZipCode(String zipCode) {
        var addressResponse = addressClient.findAddressByZipCodeClient(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
