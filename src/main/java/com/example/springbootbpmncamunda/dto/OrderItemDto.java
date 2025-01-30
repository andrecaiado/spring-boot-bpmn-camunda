package com.example.springbootbpmncamunda.dto;

import lombok.Getter;

@Getter
public class OrderItemDto {
    private String productId;
    private Double price;
    private Integer quantity;
}
