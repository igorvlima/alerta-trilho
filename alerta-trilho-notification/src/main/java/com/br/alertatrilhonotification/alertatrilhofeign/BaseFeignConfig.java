package com.br.alertatrilhonotification.alertatrilhofeign;


import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.codec.ErrorDecoder;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseFeignConfig {

    private Integer connectTimeoutMillis = 5000;

    private Integer readTimeoutMillis = 5000;

    @Bean
    Request.Options Options()  {
        return new Request.Options(connectTimeoutMillis, readTimeoutMillis);
    }

    @Bean
    public RequestInterceptor requestTokenBearerInterceptor() {

        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                String xTid = MDC.get("x-tid");
                requestTemplate.header("x-tid", xTid);
            }
        };
    }
}
