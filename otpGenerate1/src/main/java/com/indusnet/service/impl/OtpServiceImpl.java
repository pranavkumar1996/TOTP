package com.indusnet.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.indusnet.model.OtpModel;
import com.indusnet.model.common.OtpResponse;
import com.indusnet.repository.OtpRepository;
import com.indusnet.service.OtpService;
import com.indusnet.util.Util;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OtpServiceImpl implements OtpService {
@Autowired
	OtpRepository otpRepository;
	@Autowired
	Util util;
	@Override
	public OtpResponse createOtp(OtpModel otpModel) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(otpModel.getStartTime(), formatter);
		Timestamp timeStamp =Timestamp.valueOf(dateTime);
		log.info("timestamp is :"+timeStamp);
		String secret =""+ timeStamp.toInstant().toEpochMilli() + otpModel.getMobile();
		String otp = Util.generateTOTP256(secret, otpModel.getDuration(), otpModel.getDigit().toString());
		log.info("timestamp is :"+otp);
		OtpModel model = otpRepository.findByMobile(otpModel.getMobile());
		if(model == null) {		
			otpRepository.save(otpModel);
		}
		else {
			otpModel.setId(model.getId());
			otpRepository.save(otpModel);
		}
		return new OtpResponse(HttpStatus.OK.value(), "Otp is successfully generated", otp);
	}

}
