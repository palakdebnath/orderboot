package com.example.dao;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.models.Orders;
import com.example.repository.OrdersRepository;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
    private OrdersRepository ordersRepository;
	
	public OrderDAOImpl() {
        System.out.println("IssueDAOImpl");
    }
	
	@Override
	public boolean createOrder(Orders order) {
		Serializable resultOrder = ordersRepository.save(order);
		if(resultOrder != null) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override	
	public byte[] getImage(int id) {
		return ordersRepository.getImage(id);
	}
	
	@Override
	public boolean createOrderWithMultipleImage(Orders order) {
		Serializable resultOrder = ordersRepository.save(order);
		if(resultOrder != null) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public Orders getOrderDetails(String orderId) {
		return ordersRepository.findOne(orderId);
	}
}
