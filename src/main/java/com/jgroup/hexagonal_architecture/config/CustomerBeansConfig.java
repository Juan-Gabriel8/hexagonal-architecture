package com.jgroup.hexagonal_architecture.config;

import com.jgroup.hexagonal_architecture.adapters.out.AddressOutputAdapter;
import com.jgroup.hexagonal_architecture.adapters.out.CustomerOutputAdapter;
import com.jgroup.hexagonal_architecture.adapters.out.SendCpfForValidationOutputAdapter;
import com.jgroup.hexagonal_architecture.app.core.usecases.CustomerUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerBeansConfig {

    @Bean
    public CustomerUsecase customerUsecase(
            AddressOutputAdapter addressOutputAdapter,
            CustomerOutputAdapter customerOutputAdapter,
            SendCpfForValidationOutputAdapter sendCpfForValidationOutputAdapter
    ) {
        return new CustomerUsecase(addressOutputAdapter, customerOutputAdapter, sendCpfForValidationOutputAdapter);
    }
}
