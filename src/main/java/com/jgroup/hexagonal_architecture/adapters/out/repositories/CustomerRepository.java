package com.jgroup.hexagonal_architecture.adapters.out.repositories;

import com.jgroup.hexagonal_architecture.adapters.out.repositories.entities.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
