package com.example.springbootbpmncamunda.process;

import com.example.springbootbpmncamunda.dto.OrderItemDto;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestoreItems {
    private final static Logger LOG = LoggerFactory.getLogger(RestoreItems.class);

    @JobWorker(type = "restoreItemsAvailability")
    public void cancelOrder(@Variable(name = "items") List<OrderItemDto> orderId) {
        LOG.info("Restoring items availability: {}", orderId);
    }
}
