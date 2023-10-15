package com.br.alertatrilhomessagesendler.configuration;

import com.br.alertatrilhomessagesendler.domain.SmsRequest;

public interface SmsSender {
    void sendSms(SmsRequest smsRequest);
}
