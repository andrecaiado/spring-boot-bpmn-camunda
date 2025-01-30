package com.example.springbootbpmncamunda.process;

import com.example.springbootbpmncamunda.dto.CreateOrderRequestDto;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderWorker {
    private final static Logger LOG = LoggerFactory.getLogger(CreateOrderWorker.class);

    @JobWorker(type = "createOrder")
    public CreateOrderRequestDto createOrder(@Variable(name = "payload") CreateOrderRequestDto createOrderRequestDto) {
        LOG.info("Creating order: {}", createOrderRequestDto);
        return createOrderRequestDto;
    }
}
