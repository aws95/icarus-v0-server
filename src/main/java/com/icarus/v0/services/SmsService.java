package com.icarus.v0.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.icarus.v0.helpers.SmsRequest;
import com.icarus.v0.helpers.SmsSender;

@Service
public class SmsService {

	private final SmsSender smsSender;

	@Autowired
	public SmsService(@Qualifier("twilio") TwilioSmsSender smsSender) {
		this.smsSender = smsSender;

	}

	public void sendSms(SmsRequest smsRequest) {
		smsSender.sendSms(smsRequest);
	}

}
