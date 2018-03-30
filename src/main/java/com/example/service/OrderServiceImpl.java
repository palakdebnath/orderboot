package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.OrderDAO;
import com.example.models.Orders;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDAO orderDAO;
	
	@Override
	public boolean createOrder(String title, String description, String remark, byte[] image) {
		
		Orders order = new Orders();
		// order.setOrgId("123");
		// order.setAssignedWorkerId("001");
		order.setTitle(title);
		order.setDescription(description);
		order.setStatus("open");
		order.setRemark(remark);
		order.setImage1(image);
		return orderDAO.createOrder(order);
	}
	
	
	@Override
	public byte[] getImage(int id) {
		return orderDAO.getImage(id);
	}
	
	@Override
	public boolean createOrderWithMultipleImage(String orgId, String assignedWorkerId, String title, String description, String remark, byte[][] images) {
		
		Orders order = new Orders();
		order.setOrgId("123");
		order.setAssignedWorkerId("001");
		order.setTitle(title);
		order.setDescription(description);
		order.setStatus("open");
		order.setRemark("None");
		
		if(images.length >=1) {
			order.setImage1(images[0]);
		}

/*		if(images.length >= 2) {
			order.setImage1(images[1]);
		}
		
		if(images.length >= 3) {
			order.setImage1(images[2]);
		}
		
		if(images.length >= 4) {
			order.setImage1(images[3]);
		}
		
		if(images.length >= 5) {
			order.setImage1(images[4]);
		}
		*/
		return orderDAO.createOrderWithMultipleImage(order);
	}

	
	@Override
	public Orders getOrderDetails(String orderId) {
		return orderDAO.getOrderDetails(orderId);
	}
}
