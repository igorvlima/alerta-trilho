package com.br.alertmessagesendler.domain.Message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
@AllArgsConstructor
public class MessageRequest {
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    private String message;
}
