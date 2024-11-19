package com.tiffinebooking.ordermodule.service;

import java.util.List;

import com.tiffinebooking.ordermodule.dto.NewOrderDto;
import com.tiffinebooking.ordermodule.dto.UpdateOrderDto;
import com.tiffinebooking.ordermodule.entity.Orders;

public interface OrderService {

	Orders placeNewOrder(NewOrderDto dto);

	Orders getOrderById(long oId);

	List<Orders> getUserOrders(long uId);

	String deleteOrder(long oId);

	Orders updateOrder(UpdateOrderDto dto);

}
