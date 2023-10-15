package com.br.alertatrilhonotification.controller;


import com.br.alertatrilhonotification.domain.DelayRequest;
import com.br.alertatrilhonotification.exception.ErrorResponse;
import com.br.alertatrilhonotification.service.LineNotificationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Log4j2
public class LineNotificationController {


    private final LineNotificationService lineNotificationService;

    @PostMapping(value = "/create-delay")
    public ResponseEntity<Object> createDelay(@Valid @RequestBody DelayRequest request) {
            lineNotificationService.createDelay(request);
            return ResponseEntity.accepted().body(request);
    }
}
