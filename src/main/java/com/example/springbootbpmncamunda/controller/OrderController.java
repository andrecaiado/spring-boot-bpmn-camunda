package com.example.springbootbpmncamunda.controller;

import com.example.springbootbpmncamunda.dto.CreateOrderRequestDto;
import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ProcessInstanceEvent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final ZeebeClient zeebeClient;

    public OrderController(ZeebeClient zeebeClient) {
        this.zeebeClient = zeebeClient;
    }

    @PostMapping()
    public long createOrder(@RequestBody CreateOrderRequestDto createOrderRequestDto) {
        // Create order
        HashMap<String, Object> variables = new HashMap<String, Object>();
        variables.put("payload", createOrderRequestDto);

        ProcessInstanceEvent processInstance = zeebeClient.newCreateInstanceCommand() //
                .bpmnProcessId("orderProcess")
                .latestVersion()
                .variables(variables)
                .send().join();
        return processInstance.getProcessInstanceKey();
    }

}
