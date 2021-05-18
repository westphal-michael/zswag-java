package zswag.java.rest.openapi.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.reactive.config.EnableWebFlux;

import zswag.java.rest.openapi.api.ZserioCalculatorServerControllerApiClient;

@SpringBootApplication(proxyBeanMethods = false)
@EnableAsync
@EnableWebFlux
@EnableFeignClients(clients = ZserioCalculatorServerControllerApiClient.class)
@Profile("test")
public class ZserioCalculatorClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZserioCalculatorClientApplication.class, args);
    }
}
