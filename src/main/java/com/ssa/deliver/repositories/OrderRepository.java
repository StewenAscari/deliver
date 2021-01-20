package com.ssa.deliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssa.deliver.entities.Order;
import com.ssa.deliver.entities.Product;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	
	
}
