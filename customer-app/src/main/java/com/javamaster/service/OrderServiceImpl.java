package com.javamaster.service;

import com.javamaster.client.NotificationClient;
import com.javamaster.client.dto.EmailDTO;
import com.javamaster.controller.dto.OrderDTO;
import com.javamaster.model.CustomerModel;
import com.javamaster.model.OrderModel;
import com.javamaster.repository.CustomerRepository;
import com.javamaster.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final NotificationClient notificationClient;
    private final CustomerRepository customerRepository;

    @Override
    public Integer create(OrderDTO orderDto) {
        CustomerModel customerModel = findCustomer(orderDto);

        log.info("creating order: {}", orderDto);

        OrderModel orderModel = new OrderModel();
        orderModel.setComment(orderDto.getComment());
        orderModel.setCustomerId(orderDto.getCustomerId());
        log.info("saving order to the DB: {}", orderModel);
        OrderModel savedOrder = orderRepository.save(orderModel);

        prepareAndSendEmail(customerModel, savedOrder);
        return savedOrder.getId();
    }

    private CustomerModel findCustomer(OrderDTO orderDto) {
        log.info("looking for customer: {}", orderDto.getCustomerId());

        return customerRepository.findById(orderDto.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("customer not found by id"));
    }

    private void prepareAndSendEmail(CustomerModel customerModel, OrderModel savedOrder) {
        log.info("sending email..");
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setEmail(customerModel.getEmail());
        String body = String.format("Thanks for your order, %s. Your order id is: %s", customerModel.getName(), savedOrder.getId());
        emailDTO.setBody(body);
        notificationClient.sendEmail(emailDTO);
    }
}
