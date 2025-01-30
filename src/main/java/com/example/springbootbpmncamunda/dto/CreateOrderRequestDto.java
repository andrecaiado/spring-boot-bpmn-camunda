package com.example.springbootbpmncamunda.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CreateOrderRequestDto {
    private Double total;
    private List<OrderItemDto> items;
}

