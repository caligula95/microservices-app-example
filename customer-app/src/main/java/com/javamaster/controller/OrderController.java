package com.javamaster.controller;

import com.javamaster.controller.dto.OrderDTO;
import com.javamaster.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<Integer> create(@RequestBody OrderDTO orderDto) {
        log.info("handling create order: {}", orderDto);
        return ResponseEntity.ok(orderService.create(orderDto));
    }
}
