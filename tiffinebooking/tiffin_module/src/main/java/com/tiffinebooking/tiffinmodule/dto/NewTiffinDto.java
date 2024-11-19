package com.tiffinebooking.tiffinmodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewTiffinDto {
	private String tiffinName;
	private String descrption;
	private long price;
}
