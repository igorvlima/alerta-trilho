package com.br.alertatrilhonotification;

import com.br.alertatrilhonotification.domain.DelayRequest;
import com.br.alertatrilhonotification.domain.Line;
import com.br.alertatrilhonotification.domain.NotificationRequest;
import jakarta.validation.ValidationException;

public class NotificationRequestConverter {
    public static NotificationRequest convertDelayRequestToNotificationRequest(DelayRequest delayRequest) {
        if (delayRequest == null) {
            return null;
        }

        Line lineEnum = Line.fromString(delayRequest.getLine());

        if (lineEnum == null) {
            throw new ValidationException("A notificação recebida não pertence a nenhuma linha válida");
        }

        return NotificationRequest.builder()
                .line(lineEnum)
                .delayTime(delayRequest.getDelayTime())
                .description(delayRequest.getDescription())
                .build();
    }
}
