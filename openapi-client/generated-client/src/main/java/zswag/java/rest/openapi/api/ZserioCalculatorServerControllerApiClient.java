package zswag.java.rest.openapi.api;

import org.springframework.cloud.openfeign.FeignClient;
import zswag.java.rest.openapi.config.ClientConfiguration;

@FeignClient(contextId="ZserioCalculatorServerControllerApiClient", name="${openAPIDefinition.name:openAPIDefinition}", url="${openAPIDefinition.url:http://localhost:5000}", configuration = ClientConfiguration.class)
public interface ZserioCalculatorServerControllerApiClient extends ZserioCalculatorServerControllerApi {
}
