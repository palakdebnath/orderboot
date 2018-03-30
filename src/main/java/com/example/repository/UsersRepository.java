package com.example.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, String> {
	
	@Query("Select count(*) from Users")
	Long getTotalNoOfUsers();
}
