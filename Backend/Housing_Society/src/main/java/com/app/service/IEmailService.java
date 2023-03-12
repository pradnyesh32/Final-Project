package com.app.service;

import com.app.dto.RegisterDto;
import com.app.pojo.EmailVerification;

public interface IEmailService {

	String getVerification(RegisterDto request);

	EmailVerification getVerify(RegisterDto request, String otp);

}
