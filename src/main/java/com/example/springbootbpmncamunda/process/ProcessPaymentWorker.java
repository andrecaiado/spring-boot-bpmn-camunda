package com.example.springbootbpmncamunda.process;

import com.example.springbootbpmncamunda.dto.CreateOrderRequestDto;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import io.camunda.zeebe.spring.common.exception.ZeebeBpmnError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ProcessPaymentWorker {
    private final static Logger LOG = LoggerFactory.getLogger(ProcessPaymentWorker.class);

    @JobWorker(type = "processPayment")
    public CreateOrderRequestDto reserveItems(@Variable(name = "payload") CreateOrderRequestDto createOrderRequestDto) throws Exception {
        LOG.info("Processing payment: {}", createOrderRequestDto);
        if (createOrderRequestDto.getTotal() > 1000) {
            LOG.error("Payment failed");
            throw new ZeebeBpmnError("payment-error", "Payment failed", null);
        }
        return createOrderRequestDto;
    }
}
