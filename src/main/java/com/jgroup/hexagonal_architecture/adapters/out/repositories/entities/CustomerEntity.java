package com.jgroup.hexagonal_architecture.adapters.out.repositories.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customers")
public class CustomerEntity {

    @Id
    private String id;

    private String name;

    private AddressEntity addressEntity;

    private String cpf;

    private boolean isValidCpf;
}
