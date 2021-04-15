package com.example.app.service;

import com.example.app.entity.Sms;
import com.twilio.Twilio;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Service
public class SmsServiceImpl implements SmsService {
    private final String ACCOUNT_SID ="AC1dc66e728fd83f7e68ebf14d900d758d";

    private final String AUTH_TOKEN = "c0e405b3c645972a201627e6f4a4c8cd";

    private final String FROM_NUMBER = "+15713228465";

    public void send(Sms sms) {
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
                .create();
        System.out.println("here is my id:"+message.getSid());

    }

    public void receive(MultiValueMap<String, String> smscallback) {
    }
}
