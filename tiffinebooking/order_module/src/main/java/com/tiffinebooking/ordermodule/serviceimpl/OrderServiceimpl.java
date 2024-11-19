package com.tiffinebooking.ordermodule.serviceimpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tiffinebooking.ordermodule.dto.NewOrderDto;
import com.tiffinebooking.ordermodule.dto.UpdateOrderDto;
import com.tiffinebooking.ordermodule.entity.Orders;
import com.tiffinebooking.ordermodule.exception.OrderCanNotFoundException;
import com.tiffinebooking.ordermodule.repository.OrderRepository;
import com.tiffinebooking.ordermodule.service.OrderService;

@Service
public class OrderServiceimpl implements OrderService {

	@Autowired
	private OrderRepository repository;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public Orders placeNewOrder(NewOrderDto dto) {
		Orders order = new Orders();
		order.setUserId(dto.getUserId());
		order.setTiffinIds(dto.getTiffinIds());
		order.setOrderDate((LocalDate.now() + ""));
		order.setOrderTime(LocalTime.now() + "");

		// calculating Total Price of Order
		List<Long> tiffinIds = dto.getTiffinIds();
		long totalPrice = 0;
		for (Long id : tiffinIds) {
			totalPrice += restTemplate.getForObject("http://tiffin-module/api/tiffin/gettiffinprice/" + id, Long.class);
		}
		order.setTotalPrice(totalPrice);
		repository.save(order);
		return order;
	}

	@Override
	public Orders getOrderById(long oId) {
		Optional<Orders> optionalOrder = repository.findById(oId);
		if (optionalOrder.isPresent()) {
			return optionalOrder.get();
		} else {
			throw new OrderCanNotFoundException("Order not found");
		}
	}

	@Override
	public List<Orders> getUserOrders(long uId) {
		List<Orders> allOrders = repository.findAll();
		List<Orders> filtOrders = allOrders.stream().filter(o -> o.getUserId() == uId).collect(Collectors.toList());
		return filtOrders;
	}

	@Override
	public String deleteOrder(long oId) {
		repository.deleteById(oId);
		return "Order with Id "+oId+"get Deleted.";
	}

	@Override
	public Orders updateOrder(UpdateOrderDto dto) {
		//getting the particular order to update
		Orders order = repository.findById(dto.getOrderId()).get();
		
		//Updating tiffin ids
		List<Long> tempTiffins = order.getTiffinIds();
		tempTiffins.addAll(dto.getTiffinIds());
		order.setTiffinIds(tempTiffins);
		
		//setting new Date and Time
		order.setOrderDate(LocalDate.now()+"");
		order.setOrderTime(LocalTime.now()+"");
		
		//Calculating new Total Price
		long totalPrice = 0;
		for (Long id : tempTiffins) {
			totalPrice += restTemplate.getForObject("http://tiffin-module/api/tiffin/gettiffinprice/" + id, Long.class);
		}
		order.setTotalPrice(totalPrice);
		
		repository.save(order);
		return order;
	}

}
