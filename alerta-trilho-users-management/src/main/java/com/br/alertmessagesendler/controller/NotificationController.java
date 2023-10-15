package com.br.alertmessagesendler.controller;

import com.br.alertmessagesendler.domain.Delay.DelayRequest;
import com.br.alertmessagesendler.service.MessageSenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class NotificationController {
private final MessageSenderService messageSenderService;
    @PostMapping("/notification")
    public ResponseEntity<DelayRequest> sendNotification(@RequestBody DelayRequest delayRequest){
        log.info("notification received");
        messageSenderService.sendMessage(delayRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(delayRequest);


    }
}
