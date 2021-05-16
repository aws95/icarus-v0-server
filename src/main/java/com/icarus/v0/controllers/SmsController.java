package com.icarus.v0.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icarus.v0.helpers.SmsRequest;
import com.icarus.v0.services.SmsService;

@RestController
@RequestMapping({ "api/v1/sms" })
public class SmsController {

	private final SmsService smsService;
	
	
	@Autowired
	public SmsController(SmsService smsService) {
		this.smsService = smsService;
	}
	
	@PostMapping
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
		smsService.sendSms(smsRequest);
    }
	
	
}
