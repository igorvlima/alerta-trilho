package com.br.alertatrilhomessagesendler.service;

import com.br.alertatrilhomessagesendler.configuration.SmsSender;
import com.br.alertatrilhomessagesendler.domain.SmsRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class Service {

    private final SmsSender smsSender;

    public void sendSms(SmsRequest smsRequest) {
        System.out.println("Received message from users management: "+smsRequest);
        smsSender.sendSms(smsRequest);
    }
}
