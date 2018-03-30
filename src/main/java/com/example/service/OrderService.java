package com.example.service;

import com.example.models.Orders;

public interface OrderService {
	public boolean createOrder(String title, String description, String remark, byte[] image);

	public boolean createOrderWithMultipleImage(String orgId, String assignedWorkerId, String title, String description, String remark, byte[][] images);

    public Orders getOrderDetails(String orderId);
    
    public byte[] getImage(int id);
}
