package com.jgroup.hexagonal_architecture.adapters.out.repositories.mapper;

import com.jgroup.hexagonal_architecture.adapters.out.repositories.entities.CustomerEntity;
import com.jgroup.hexagonal_architecture.app.core.domain.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);
}
