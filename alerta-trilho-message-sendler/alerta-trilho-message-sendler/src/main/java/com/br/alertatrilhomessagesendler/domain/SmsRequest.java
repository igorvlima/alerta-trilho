package com.br.alertatrilhomessagesendler.domain;

;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @param phoneNumber destination
 */
public record SmsRequest(String phoneNumber, String message) {

    public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber,
                      @JsonProperty("message") String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    @Override
    public String toString() {
        return "SmsRequest{" +
                "phoneNumber= " + phoneNumber + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
