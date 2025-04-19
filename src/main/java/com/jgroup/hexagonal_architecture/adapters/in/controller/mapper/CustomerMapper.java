package com.jgroup.hexagonal_architecture.adapters.in.controller.mapper;

import com.jgroup.hexagonal_architecture.adapters.in.controller.request.CustomerRequest;
import com.jgroup.hexagonal_architecture.app.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);
}
