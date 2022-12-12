package com.indusnet.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OtpResponse {
	private Integer status;
	private String message;
	private String otp;
}
