package com.example.spring_boot_bpmn_camunda;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ChargeCreditCardWorker {
    private final static    Logger LOG = LoggerFactory.getLogger(ChargeCreditCardWorker.class);
    @JobWorker(type = "charge-credit-card")
    public Map<String, Double> chargeCreditCard(@Variable(name = "totalWithTax") Double totalWithTax) {
        LOG.info("charging credit card: {}", totalWithTax);
        return Map.of("amountCharged", totalWithTax);
    }
}
