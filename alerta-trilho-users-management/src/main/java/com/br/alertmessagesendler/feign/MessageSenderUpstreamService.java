package com.br.alertmessagesendler.feign;

import com.br.alertmessagesendler.domain.Message.MessageRequest;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "messageSender", url = "localhost:8080", configuration = BaseFeignConfig.class)
@Component
public interface MessageSenderUpstreamService {

    @PostMapping(value = "/api/v1/sms", produces = MediaType.ALL_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Response sendMessage(@RequestBody MessageRequest message);
}
