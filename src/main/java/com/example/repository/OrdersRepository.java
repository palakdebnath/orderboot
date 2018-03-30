package com.example.repository;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.models.Orders;

public interface OrdersRepository  extends CrudRepository<Orders, String> {
	
	@Query("Select image1 from Orders where orgId=:id")
	byte[] getImage(@Param("id") int id);
}
