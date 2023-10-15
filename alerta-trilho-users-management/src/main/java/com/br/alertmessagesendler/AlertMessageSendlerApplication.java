package com.br.alertmessagesendler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlertMessageSendlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlertMessageSendlerApplication.class, args);
    }

}
