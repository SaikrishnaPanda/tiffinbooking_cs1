package com.tiffinebooking.usermodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto {
	private long userId;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
}
