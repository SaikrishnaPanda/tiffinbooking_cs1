package com.tiffinebooking.ordermodule.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiffinebooking.ordermodule.dto.NewOrderDto;
import com.tiffinebooking.ordermodule.dto.UpdateOrderDto;
import com.tiffinebooking.ordermodule.entity.Orders;
import com.tiffinebooking.ordermodule.service.OrderService;

@RestController
@RequestMapping("api/order")
@CrossOrigin(origins = "http://localhost:4200/")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@PostMapping("/neworder")
//	@CircuitBreaker(name = "itemPriceBreaker",fallbackMethod = "itemPriceFallBack")
	private ResponseEntity<Orders> placeNewOrder(@RequestBody NewOrderDto dto){
		Orders ordertoken = service.placeNewOrder(dto);
		return ResponseEntity.status(HttpStatus.OK).body(ordertoken);
	}
	
	public ResponseEntity<Orders>itemPriceFallBack(NewOrderDto dto, Exception ex){
		 // Create an instance of Orders using the builder pattern
	    Orders ord = Orders.builder()
	            .orderId(00L)
	            .userId(0L)
	            .tiffinIds(Arrays.asList(0L, 0L))
	            .orderDate("0000-00-00")
	            .orderTime("00:00:00.000000")
	            .totalPrice(000)
	            .build();
		
		return ResponseEntity.status(HttpStatus.OK).body(ord);
	}
	
	@GetMapping("/getorder/{oId}")
	private ResponseEntity<Orders> getOrderById(@PathVariable("oId") long oId){
		Orders order = service.getOrderById(oId);
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}
	
	@GetMapping("/getuserorder/{uId}")
	private ResponseEntity <List<Orders>> getUserOrders(@PathVariable("uId")long uId){
		List<Orders> order = service.getUserOrders(uId);
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}
	
	@PutMapping("/updateorder")
	private ResponseEntity<Orders> updateOrder(@RequestBody UpdateOrderDto dto){
		Orders order = service.updateOrder(dto);
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}
	
	@DeleteMapping("/deleteorder/{oId}")
	private ResponseEntity<?> deleteOrder(@PathVariable("oId") long oId){
		String rtn = service.deleteOrder(oId);
		return ResponseEntity.status(HttpStatus.OK).body(rtn);
	}
}
