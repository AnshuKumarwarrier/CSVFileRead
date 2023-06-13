 package com.csvreader.assesmen.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.csvreader.assesmen.model.Order;
import com.csvreader.assesmen.service.OrderService;

@RestController
@RequestMapping("/api/v1.1")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/import")
	    public ResponseEntity<String> importOrders(@RequestParam("file") MultipartFile file) {
	        try {
	            orderService.importOrders(file);
	            return ResponseEntity.status(HttpStatus.OK).body("Orders imported successfully.");
	        } catch (IOException e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error importing orders: " + e.getMessage());
	        }
	    }

	    @GetMapping("/orders")
	    public ResponseEntity<List<Order>> getAllOrders() {
	        List<Order> orders = orderService.getAllOrders();
	        return ResponseEntity.ok(orders);
	    }
}