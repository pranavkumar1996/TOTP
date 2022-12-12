package com.indusnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indusnet.model.OtpModel;
import com.indusnet.model.common.OtpResponse;
import com.indusnet.service.OtpService;

@RestController
@RequestMapping("/api/v0.0.1/otp")
public class OtpController {
	@Autowired
	OtpService otpService;
	@PostMapping("/generateotp")
	public ResponseEntity<OtpResponse> generateOtp(@RequestBody OtpModel model){
		OtpResponse responce =otpService.createOtp(model);
		return new ResponseEntity<OtpResponse>(responce, HttpStatus.OK);
	}

}
