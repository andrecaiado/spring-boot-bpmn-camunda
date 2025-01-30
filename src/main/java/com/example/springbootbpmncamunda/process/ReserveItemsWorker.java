package com.example.springbootbpmncamunda.process;

import com.example.springbootbpmncamunda.dto.CreateOrderRequestDto;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ReserveItemsWorker {
    private final static Logger LOG = LoggerFactory.getLogger(ReserveItemsWorker.class);

    @JobWorker(type = "reserveItems")
    public CreateOrderRequestDto reserveItems(@Variable(name = "payload") CreateOrderRequestDto createOrderRequestDto) {
        LOG.info("Reserving items: {}", createOrderRequestDto);
        return createOrderRequestDto;
    }
}
