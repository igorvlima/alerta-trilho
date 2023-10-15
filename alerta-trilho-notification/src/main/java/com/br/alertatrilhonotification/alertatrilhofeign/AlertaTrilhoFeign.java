package com.br.alertatrilhonotification.alertatrilhofeign;

import com.br.alertatrilhonotification.domain.DelayRequest;
import com.br.alertatrilhonotification.domain.NotificationRequest;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "alertaTrilho", url = "localhost:8090", configuration = BaseFeignConfig.class)
@Component
public interface AlertaTrilhoFeign {

    @PostMapping(value = "/notification", produces = MediaType.ALL_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Response sendNotification(@RequestBody NotificationRequest request);

}
