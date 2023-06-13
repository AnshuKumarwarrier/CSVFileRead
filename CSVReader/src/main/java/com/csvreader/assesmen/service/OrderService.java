package com.csvreader.assesmen.service;



import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.csvreader.assesmen.model.Order;


public interface OrderService {


	List<Order> getAllOrders();

	void importOrders(MultipartFile file) throws IOException;

}
