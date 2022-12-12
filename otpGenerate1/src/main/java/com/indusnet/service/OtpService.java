package com.indusnet.service;

import org.springframework.http.ResponseEntity;

import com.indusnet.model.OtpModel;
import com.indusnet.model.common.OtpResponse;

public interface OtpService {

	public OtpResponse createOtp(OtpModel otpModel);
}
