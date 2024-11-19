package com.tiffinebooking.ordermodule.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderDto {
	private long orderId;
	private long userId;
	private List<Long> tiffinIds;
}
