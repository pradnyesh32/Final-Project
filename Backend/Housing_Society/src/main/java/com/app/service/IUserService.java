package com.app.service;

import com.app.dto.LoginDto;
import com.app.dto.RegisterDto;
import com.app.pojo.User;

public interface IUserService {
	 
	User registerUser(RegisterDto request,String otp);

	User loginUser(LoginDto request);

	User addTemp(User ird, long id);

	RegisterDto tempUser(RegisterDto request); 
	

}
