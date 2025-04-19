package com.jgroup.hexagonal_architecture.adapters.out.client.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {

    private String street;

    private String city;

    private String state;

}
