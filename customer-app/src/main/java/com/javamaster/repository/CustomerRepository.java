package com.javamaster.repository;

import com.javamaster.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerModel, Integer> {
}
