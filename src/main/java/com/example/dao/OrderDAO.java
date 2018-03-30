package com.example.dao;

import com.example.models.Orders;

public interface OrderDAO {
	public boolean createOrder(Orders order);
	
	public boolean createOrderWithMultipleImage(Orders order);
	
	public Orders getOrderDetails(String orderId);

	public byte[] getImage(int id);
}
