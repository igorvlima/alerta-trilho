
package com.br.alertatrilhonotification.service;

import com.br.alertatrilhonotification.NotificationRequestConverter;
import com.br.alertatrilhonotification.alertatrilhofeign.AlertaTrilhoFeign;
import com.br.alertatrilhonotification.domain.DelayRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class LineNotificationService {

    private final AlertaTrilhoFeign alertaTrilhoFeign;
    public void createDelay(DelayRequest delayRequest){
        log.info("Sending notification to alerta trilho sender");

            var notificationRequest = NotificationRequestConverter.convertDelayRequestToNotificationRequest(delayRequest);
            var request = alertaTrilhoFeign.sendNotification(notificationRequest);

        log.info("Request send with status code: {}", request.status());
    }
}

