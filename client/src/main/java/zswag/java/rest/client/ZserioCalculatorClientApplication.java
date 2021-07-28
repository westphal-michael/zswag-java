package zswag.java.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.reactive.config.EnableWebFlux;

import example.calculator.Double;
import example.calculator.I32;
import lombok.extern.slf4j.Slf4j;
import zswag.java.rest.spring.SpringZserioConverterRegistrar;

@SpringBootApplication(proxyBeanMethods = false)
@EnableAsync
@EnableWebFlux
@EnableFeignClients()
@Import(SpringZserioConverterRegistrar.class)
@Slf4j
public class ZserioCalculatorClientApplication implements ApplicationRunner {

    @Autowired
    protected Environment environment;

    @Autowired
    private ZserioCalculatorClientController serviceController;

    public static void main(String[] args) {
        SpringApplication.run(ZserioCalculatorClientApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (String profileName : environment.getActiveProfiles()) {
            if (!profileName.equals("test")) {
                Double value = serviceController.powerOfTwo(new I32(5));
                log.info("5th power of 2 = {}", value.getValue());

                value = serviceController.power(new I32(6), new I32(3));
                log.info("3rd power of 6 = {}", value.getValue());

                System.exit(0);
            }
        }
    }
}
