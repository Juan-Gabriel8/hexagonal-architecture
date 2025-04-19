package com.jgroup.hexagonal_architecture.app.ports.out;

import com.jgroup.hexagonal_architecture.app.core.domain.Address;

public interface AddressOutputPort {

    Address findAddressByZipCode(String ZipCode);
}
