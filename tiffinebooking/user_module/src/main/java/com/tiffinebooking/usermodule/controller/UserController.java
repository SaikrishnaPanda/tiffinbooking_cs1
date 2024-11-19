package com.tiffinebooking.usermodule.controller;

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

import com.tiffinebooking.usermodule.dto.NewUserDto;
import com.tiffinebooking.usermodule.dto.UpdateUserDto;
import com.tiffinebooking.usermodule.entity.Users;
import com.tiffinebooking.usermodule.service.UserService;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {
	
	
	@Autowired
	private UserService service;
	
	//Creating New User
	@PostMapping("/newuser")
	public ResponseEntity<Users> crateNewUser(@RequestBody NewUserDto dto){
		Users rtn = service.crateNewUser(dto);
		return ResponseEntity.status(HttpStatus.OK).body(rtn);
	}
	
	//Get User by UserId
	@GetMapping("/getuser-byid/{uId}")
	public ResponseEntity<?> getUserDetailsById(@PathVariable("uId") long uId){
		Users user = service.getUserDetailsById(uId);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	//Update a User
	@PutMapping("/updateuser")
	public ResponseEntity<?> updateUser(@RequestBody UpdateUserDto dto){
		String rtn = service.updateUser(dto);
		return ResponseEntity.status(HttpStatus.OK).body(rtn);
	}
	
	//Delete a User
	@DeleteMapping("/deleteuser/{uId}")
	public ResponseEntity<?> deleteUserById(@PathVariable("uId") long uId){
		String rtn = service.deleteUserById(uId);
		return ResponseEntity.status(HttpStatus.OK).body(rtn);
	}
}
