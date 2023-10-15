package com.br.alertatrilhonotification.domain;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@Builder
@Data
public class NotificationRequest {
    Line line;
    LocalDateTime delayTime;
    String description;
}
