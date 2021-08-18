package com.equitas.userservice.util;

public class OtpGenrator {
	public long otpGenerater() {
		return Math.round(Math.random() * 100000);
	}
}
