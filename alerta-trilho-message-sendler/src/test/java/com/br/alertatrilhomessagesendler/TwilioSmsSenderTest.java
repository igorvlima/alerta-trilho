package com.br.alertatrilhomessagesendler;

import com.br.alertatrilhomessagesendler.configuration.TwilioConfiguration;
import com.br.alertatrilhomessagesendler.domain.SmsRequest;
import com.br.alertatrilhomessagesendler.service.TwilioSmsSender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class TwilioSmsSenderTest {
    @Mock
    private TwilioConfiguration twilioConfiguration;

    private TwilioSmsSender smsSender;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        smsSender = new TwilioSmsSender(twilioConfiguration);
    }

    @Test
    void testSendSmsWithInvalidPhoneNumber() {

        SmsRequest smsRequest = new SmsRequest("+55123123", "Test message");

        assertThrows(IllegalArgumentException.class, () -> smsSender.sendSms(smsRequest));
    }

    @Test
    void testIsPhoneNumberValid() {

        String invalidPhoneNumber = "+5511123";

        assertFalse(smsSender.isPhoneNumberValid(invalidPhoneNumber));
    }
}
