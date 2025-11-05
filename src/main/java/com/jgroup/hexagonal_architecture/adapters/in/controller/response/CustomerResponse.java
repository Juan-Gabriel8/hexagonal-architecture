package com.jgroup.hexagonal_architecture.adapters.in.controller.response;

import com.jgroup.hexagonal_architecture.app.core.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

    private String name;

    private AddressResponse address;

    private String cpf;

    private boolean isValidCpf;
}
