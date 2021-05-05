package zswag.java.rest.client;

import org.springframework.cloud.openfeign.FeignClient;

import zswag.java.rest.api.ZserioCalculatorServiceInterface;

@FeignClient(name = "calculator-client", url = "${feign.url}")
public interface ZserioCalculatorServiceClient extends ZserioCalculatorServiceInterface {
}
