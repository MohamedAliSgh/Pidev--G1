package tn.esprit.spring.service;

import org.springframework.util.MultiValueMap;

import tn.esprit.spring.entities.Sms;



public interface SmsService {
	public void send(Sms sms);
	public void receive(MultiValueMap<String, String> smscallback);
}
