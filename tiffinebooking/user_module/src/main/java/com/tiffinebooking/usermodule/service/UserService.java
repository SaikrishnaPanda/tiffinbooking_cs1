package com.tiffinebooking.usermodule.service;

import com.tiffinebooking.usermodule.dto.NewUserDto;
import com.tiffinebooking.usermodule.dto.UpdateUserDto;
import com.tiffinebooking.usermodule.entity.Users;

public interface UserService {

	public Users crateNewUser(NewUserDto dto);

	public Users getUserDetailsById(long uId);

	public String updateUser(UpdateUserDto dto);

	public String deleteUserById(long uId);

}
