package com.ssa.deliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssa.deliver.dto.OrderDTO;
import com.ssa.deliver.dto.ProductDTO;
import com.ssa.deliver.entities.Order;
import com.ssa.deliver.entities.OrderStatus;
import com.ssa.deliver.entities.Product;
import com.ssa.deliver.repositories.OrderRepository;
import com.ssa.deliver.repositories.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> list = orderRepository.findOrderWithProducts();
		
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
		
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO orderDTO){
		
		Order order = new Order(null, orderDTO.getAddress(), orderDTO.getLatitude(), orderDTO.getLongitude(),
								Instant.now(), OrderStatus.PENDING);
		for(ProductDTO p : orderDTO.getProducts()) {
			
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		
		order = orderRepository.save(order);
		 
		return new OrderDTO(order);
	}
	
	@Transactional
	public OrderDTO setDevivered(Long id){
		
		 Order order = orderRepository.getOne(id);
		 order.setStatus(OrderStatus.DELIVERED);
		 
		 order = orderRepository.save(order);
		 
		 return new OrderDTO(order);
	}
	

}
