package zswag.java.rest.server;

import org.springframework.cloud.openfeign.FeignClient;

import zswag.java.rest.api.ZserioCalculatorServiceInterface;

@FeignClient(name = "calculator-client", url = "${feign.url}")
public interface ZserioCalculatorServiceTestClient extends ZserioCalculatorServiceInterface {
}
