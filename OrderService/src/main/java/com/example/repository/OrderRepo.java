package com.example.repository;

import com.example.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderRepo extends JpaRepository<OrderEntity, Long> {

}

