package com.br.alertatrilhomessagesendler.service;

import com.br.alertatrilhomessagesendler.domain.SmsRequest;
import com.br.alertatrilhomessagesendler.configuration.SmsSender;
import com.br.alertatrilhomessagesendler.configuration.TwilioConfiguration;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("twilio")
public class TwilioSmsSender implements SmsSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        if (isPhoneNumberValid(smsRequest.phoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequest.phoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = smsRequest.message();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            LOGGER.info("Send sms {}", smsRequest);
        } else {
            throw new IllegalArgumentException(
                    "Phone number [" + smsRequest.phoneNumber() + "] is not a valid number"
            );
        }
    }

    public boolean isPhoneNumberValid(String phoneNumber) {

        String padrao = "^\\+\\d{2,4}\\d{9}$";

        Pattern pattern = Pattern.compile(padrao);

        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }

}

