package zswag.java.rest.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.reactive.config.EnableWebFlux;

import zswag.java.rest.spring.SpringZserioConverterRegistrar;

@SpringBootApplication(proxyBeanMethods = false)
@EnableAsync
@EnableWebFlux
@EnableFeignClients()
@Import(SpringZserioConverterRegistrar.class)
@Profile("test")
public class ZserioCalculatorClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZserioCalculatorClientApplication.class, args);
    }
}
