package com.example.app.service;

import org.springframework.util.MultiValueMap;

import com.example.app.entity.Sms;

public interface SmsService {
	public void send(Sms sms);
	public void receive(MultiValueMap<String, String> smscallback);
}
