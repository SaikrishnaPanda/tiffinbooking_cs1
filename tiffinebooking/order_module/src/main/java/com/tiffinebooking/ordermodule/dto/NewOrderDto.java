package com.tiffinebooking.ordermodule.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewOrderDto {
	private long userId;
	private List<Long> tiffinIds;
//	private String orderDate;
//	private String orderTime;
}
