package com.tiffinebooking.usermodule.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String address;
	
	private String phone;
}
