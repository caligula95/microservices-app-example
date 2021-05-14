package com.javamaster.service;

import com.javamaster.controller.dto.OrderDTO;

public interface OrderService {
    Integer create(OrderDTO orderDto);
}
