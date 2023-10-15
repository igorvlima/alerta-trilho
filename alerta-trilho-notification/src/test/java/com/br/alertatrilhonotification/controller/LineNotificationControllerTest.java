package com.br.alertatrilhonotification.controller;

import com.br.alertatrilhonotification.NotificationRequestConverter;
import com.br.alertatrilhonotification.domain.DelayRequest;
import com.br.alertatrilhonotification.service.LineNotificationService;
import jakarta.validation.ValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class LineNotificationControllerTest {

    @Test
    void createDelayWithInvalidLine() {
        DelayRequest delayRequest = new DelayRequest("Teste", LocalDateTime.now(), "Teste");

        assertThrows(ValidationException.class, () -> {
            NotificationRequestConverter.convertDelayRequestToNotificationRequest(delayRequest);
        });
    }

    @Test
    void createDelayWithNullLine() {
        DelayRequest delayRequest = new DelayRequest(null, LocalDateTime.now(), "Teste");

        assertThrows(ValidationException.class, () -> {
            NotificationRequestConverter.convertDelayRequestToNotificationRequest(delayRequest);
        });
    }
}
