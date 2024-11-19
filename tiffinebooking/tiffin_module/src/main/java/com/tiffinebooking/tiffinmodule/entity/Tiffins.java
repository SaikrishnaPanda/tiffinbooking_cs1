package com.tiffinebooking.tiffinmodule.entity;

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
public class Tiffins {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long tiffinId;
	
	private String tiffinName;
	
	private String descrption;
	
	private long price;
}
