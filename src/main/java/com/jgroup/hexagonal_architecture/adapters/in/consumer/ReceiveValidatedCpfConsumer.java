package com.jgroup.hexagonal_architecture.adapters.in.consumer;

import com.jgroup.hexagonal_architecture.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.jgroup.hexagonal_architecture.adapters.in.consumer.message.CustomerMessage;
import com.jgroup.hexagonal_architecture.app.ports.in.CustomerImputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    CustomerImputPort customerImputPort;
    @Autowired
    CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "juan")
    public void receive(CustomerMessage customerMessage) {
        var customer  = customerMessageMapper.toCustomer(customerMessage);
        customerImputPort.updateCustomer(customer, customerMessage.getZipCode());

    }
}
