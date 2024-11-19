package com.tiffinebooking.usermodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserDto {
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String phone;
}
