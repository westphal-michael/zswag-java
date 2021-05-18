package zswag.java.rest.openapi.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.reactive.config.EnableWebFlux;

import lombok.extern.slf4j.Slf4j;
import zswag.java.rest.openapi.api.ZserioCalculatorServerControllerApiClient;
import zswag.java.rest.openapi.model.DoubleOpenApi;
import zswag.java.rest.openapi.model.I32OpenApi;

@SpringBootApplication(proxyBeanMethods = false)
@EnableAsync
@EnableWebFlux
@EnableFeignClients(clients = ZserioCalculatorServerControllerApiClient.class)
@Profile("default")
@Slf4j
public class ZserioCalculatorClientConsoleApplication implements ApplicationRunner {
    @Autowired
    private ZserioCalculatorClientController serviceController;

    public static void main(String[] args) {
        SpringApplication.run(ZserioCalculatorClientConsoleApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        I32OpenApi base = new I32OpenApi();
        I32OpenApi exponent = new I32OpenApi();

        exponent.setValue(5);
        DoubleOpenApi value = serviceController.powerOfTwo(exponent);
        log.info("5th power of 2 = {}", value == null ? "null" : value.getValue());

        base.setValue(6);
        exponent.setValue(3);
        value = serviceController.power(base, exponent);
        log.info("3rd power of 6 = {}", value == null ? "null" : value.getValue());

        System.exit(0);
    }
}
