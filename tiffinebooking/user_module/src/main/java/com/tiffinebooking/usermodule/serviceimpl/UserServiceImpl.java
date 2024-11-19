package com.tiffinebooking.usermodule.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiffinebooking.usermodule.dto.NewUserDto;
import com.tiffinebooking.usermodule.dto.UpdateUserDto;
import com.tiffinebooking.usermodule.entity.Users;
import com.tiffinebooking.usermodule.repository.UserRepository;
import com.tiffinebooking.usermodule.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public Users crateNewUser(NewUserDto dto) {
		
		Users user = new Users();
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setEmail(dto.getEmail());
		user.setAddress(dto.getAddress());
		user.setPhone(dto.getPhone());
		Users rtnuser = repository.save(user);
		return rtnuser;
	}

	@Override
	public Users getUserDetailsById(long uId) {
		Users user = repository.findById(uId).get();
		return user;
	}

	@Override
	public String updateUser(UpdateUserDto dto) {
		
		Users user = repository.findById(dto.getUserId()).get();
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setAddress(dto.getAddress());
		user.setPhone(dto.getPhone());
		repository.save(user);
		return "User with ID "+dto.getUserId()+"get Updated";
	}

	@Override
	public String deleteUserById(long uId) {
		repository.deleteById(uId);
		return "User with Id "+uId+" get Deleted.";
	}

}
