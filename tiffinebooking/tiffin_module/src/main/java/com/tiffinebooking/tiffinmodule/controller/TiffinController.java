package com.tiffinebooking.tiffinmodule.controller;

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

import com.tiffinebooking.tiffinmodule.dto.NewTiffinDto;
import com.tiffinebooking.tiffinmodule.dto.UpdateTiffinDto;
import com.tiffinebooking.tiffinmodule.entity.Tiffins;
import com.tiffinebooking.tiffinmodule.service.TiffinService;

@RestController
@RequestMapping("/api/tiffin")
@CrossOrigin(origins = "http://localhost:4200/")
public class TiffinController {
	
	@Autowired
	private TiffinService service;
	
	@PostMapping("/newtiffin")
	public ResponseEntity<?> createNewTiffin(@RequestBody NewTiffinDto dto){
		String rtn = service.createNewTiffin(dto);
		return ResponseEntity.status(HttpStatus.OK).body(rtn);
	}
	
	@GetMapping("/getiffin/{tId}")
	public ResponseEntity<?> getTiffinById(@PathVariable("tId") long tId){
		Tiffins tiffin = service.getTiffinById(tId);
		return ResponseEntity.status(HttpStatus.OK).body(tiffin);
	}
	@GetMapping("/getalltiffins")
	public ResponseEntity<?> getAllTiffins(){
		List<Tiffins> allTiffins = service.getAllTiffins();
		return ResponseEntity.status(HttpStatus.OK).body(allTiffins);
	}
	
	@PutMapping("/updatetiffin")
	public ResponseEntity<?> updateTiffinInfo(@RequestBody UpdateTiffinDto dto){
		String rtn = service.updateTiffinInfo(dto);
		return ResponseEntity.status(HttpStatus.OK).body(rtn);
	}
	
	@DeleteMapping("/deletetiffin/{tId}")
	public ResponseEntity<?> deleteTiffinById(@PathVariable("tId") long tId){
		String rtn = service.deleteTiffinById(tId);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	//Business APIs for MS communications
	@GetMapping("/gettiffinprice/{tId}")
	public ResponseEntity<Long> getTiffinPriceById(@PathVariable("tId") long tId){
		long tiffinPrice = service.getTiffinPriceById(tId);
		return ResponseEntity.status(HttpStatus.OK).body(tiffinPrice);
	}
	
}
