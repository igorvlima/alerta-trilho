package com.br.alertatrilhonotification.domain;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.databind.annotation.EnumNaming;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class DelayRequest {
    @NotNull(message = "Line cannot be null")
    private String line;
    private LocalDateTime delayTime;
    private String description;
}
