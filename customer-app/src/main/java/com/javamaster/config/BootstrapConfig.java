package com.javamaster.config;

import com.javamaster.model.CustomerModel;
import com.javamaster.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class BootstrapConfig {

    @Autowired
    private CustomerRepository customerRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void createCustomer() {
        CustomerModel customerModel = new CustomerModel();
        customerModel.setName("John Snow");
        customerModel.setEmail("john@gmail.com");
        customerRepository.save(customerModel);
    }
}
