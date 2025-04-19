package com.jgroup.hexagonal_architecture.adapters.out.client.mapper;

import com.jgroup.hexagonal_architecture.adapters.out.client.response.AddressResponse;
import com.jgroup.hexagonal_architecture.app.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
