package zswag.java.rest.server;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.extern.slf4j.Slf4j;
import zswag.java.rest.spring.SpringZserioConverterRegistrar;

@SpringBootApplication(proxyBeanMethods = false)
@EnableAsync
@EnableWebFlux
@Import(SpringZserioConverterRegistrar.class)
@Slf4j
public class ZserioCalculatorServerApplication implements ApplicationRunner {

    @Value("${local.server.port:}")
    protected String localServerPort;

    @Value("${server.port:}")
    protected String serverPort;

    @Bean
    @SuppressWarnings("deprecation")
    // workaround for using springdoc-openapi with Spring Webflux
    public RouterFunction<ServerResponse> indexRouter(@Value("classpath:/static/index.html") final Resource indexHtml) {
        return route(GET("/"), request -> ok().contentType(MediaType.TEXT_HTML).syncBody(indexHtml));
    }

    public static void main(String[] args) {
        SpringApplication.run(ZserioCalculatorServerApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        InetAddress localHost = null;
        try {
            localHost = Inet4Address.getLocalHost();
        } catch (UnknownHostException e) {
            log.error(e.getMessage());
        }
        String ip = localHost.getHostAddress();
        log.info("started REST server {} on port {}{}", ip, serverPort, localServerPort);
    }
}
