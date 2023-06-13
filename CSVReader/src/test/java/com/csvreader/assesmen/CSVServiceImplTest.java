package com.csvreader.assesmen;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;

import com.csvreader.assesmen.model.Order;
import com.csvreader.assesmen.repository.OrderRepo;
import com.csvreader.assesmen.service.OrderService;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CSVServiceImplTest {

	@Mock
    private OrderRepo orderRepository;

    @InjectMocks
    private OrderService orderService;

    public CSVServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testImportOrders() throws IOException {
        String csvData = "1, john@example.com, (237) 123456789, 1.5";
        MockMultipartFile file = new MockMultipartFile("file", "orders.csv", "text/csv", csvData.getBytes());

        orderService.importOrders(file);

        verify(orderRepository, times(1)).saveAll(anyList());
    }

    @Test
    public void testGetAllOrders() {
        List<Order> orders = Collections.singletonList(new Order("1", "john@example.com", "(237) 123456789", 1.5, "Cameroon"));
        when(orderRepository.findAll()).thenReturn(orders);

        List<Order> result = orderService.getAllOrders();

        assertEquals(orders, result);
    }
}