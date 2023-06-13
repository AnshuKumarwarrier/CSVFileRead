package com.csvreader.assesmen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csvreader.assesmen.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{

}
