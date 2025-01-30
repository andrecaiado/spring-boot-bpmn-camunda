package com.example.springbootbpmncamunda;

import io.camunda.zeebe.spring.client.annotation.Deployment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Deployment(resources = "classpath:process-order.bpmn")
public class SpringBootBpmnCamundaApplication {

	private static final Logger LOG = LoggerFactory.getLogger(SpringBootBpmnCamundaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBpmnCamundaApplication.class, args);
	}
}
