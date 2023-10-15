package com.br.alertatrilhonotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlertaTrilhoNotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlertaTrilhoNotificationApplication.class, args);
    }

}
