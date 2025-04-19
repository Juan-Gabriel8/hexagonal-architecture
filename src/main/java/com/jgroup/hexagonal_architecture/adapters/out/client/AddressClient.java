package com.jgroup.hexagonal_architecture.adapters.out.client;

import com.jgroup.hexagonal_architecture.adapters.out.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AddressClient", url = "${external-api.client.address.url}")
public interface AddressClient {

    @GetMapping("/{zipCode}")
    AddressResponse findAddressByZipCodeClient(@PathVariable(name = "zipCode") String zipCode);
}
