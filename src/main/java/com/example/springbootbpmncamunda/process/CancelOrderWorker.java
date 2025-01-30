package com.example.springbootbpmncamunda.process;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CancelOrderWorker {
    private final static Logger LOG = LoggerFactory.getLogger(CancelOrderWorker.class);

    @JobWorker(type = "cancelOrder")
    public void cancelOrder(@Variable(name = "orderId") String orderId) {
        LOG.info("Cancelling order. Id: {}", orderId);
    }
}
