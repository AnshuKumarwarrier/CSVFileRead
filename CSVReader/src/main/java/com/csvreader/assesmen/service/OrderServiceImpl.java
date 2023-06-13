package com.csvreader.assesmen.service;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.csvreader.assesmen.model.Order;
import com.csvreader.assesmen.repository.OrderRepo;


@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepo  orderRepo;

	
		@Override
		public List<Order> getAllOrders() {
			// TODO Auto-generated method stub
			return orderRepo.findAll();
		}


		@Override
		public void importOrders(MultipartFile file) {
	        List<Order> orders = new ArrayList<>();

	        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] data = line.split(",");
	                if (data.length == 4) {
	                    String id = data[0].trim();
	                    String email = data[1].trim();
	                    String phoneNumber = data[2].trim();
	                    double parcelWeight = Double.parseDouble(data[3].trim());

	                    String country = determineCountry(phoneNumber);

	                    Order order = new Order(id, email, phoneNumber, parcelWeight, country);
	                    orders.add(order);
	                }
	            }
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        orderRepo.saveAll(orders);
	    }


		 private String determineCountry(String phoneNumber) {
		        if (phoneNumber.matches("\\(237\\)\\ ?[2368]\\d{7,8}$")) {
		            return "Cameroon";
		        } else if (phoneNumber.matches("\\(251\\)\\ ?[1-59]\\d{8}$")) {
		            return "Ethiopia";
		        } else if (phoneNumber.matches("\\(212\\)\\ ?[5-9]\\d{8}$")) {
		            return "Morocco";
		        } else if (phoneNumber.matches("\\(258\\)\\ ?[28]\\d{7,8}$")) {
		            return "Mozambique";
		        } else if (phoneNumber.matches("\\(256\\)\\ ?\\d{9}$")) {
		            return "Uganda";
		        } else {
		            return "Unknown";
		        }
		    }

	}