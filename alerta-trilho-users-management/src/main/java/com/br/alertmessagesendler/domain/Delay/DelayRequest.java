package com.br.alertmessagesendler.domain.Delay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class DelayRequest {
    private Line line;
    private LocalDateTime delayTime;
    private String description;
}
