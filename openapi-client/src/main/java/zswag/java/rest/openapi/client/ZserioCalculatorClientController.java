package zswag.java.rest.openapi.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import zswag.java.rest.openapi.api.ZserioCalculatorServerControllerApiClient;
import zswag.java.rest.openapi.model.BaseAndExponentOpenApi;
import zswag.java.rest.openapi.model.DoubleOpenApi;
import zswag.java.rest.openapi.model.I32OpenApi;

@RestController
@Slf4j
public class ZserioCalculatorClientController {
    @Autowired
    private ZserioCalculatorServerControllerApiClient client;

    public DoubleOpenApi powerOfTwo(I32OpenApi exponent) {
        I32OpenApi base = new I32OpenApi();
        base.setValue(2);
        return power(base, exponent);
    }

    public DoubleOpenApi power(I32OpenApi base, I32OpenApi exponent) {
        BaseAndExponentOpenApi baseAndExponent = new BaseAndExponentOpenApi();
        baseAndExponent.setBase(base);
        baseAndExponent.setExponent(exponent);
        return client.power(baseAndExponent).getBody();
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleAnyException(RuntimeException exception) {
        String message = "client exception: " + exception.getMessage();
        log.error(message);
        return message;
    }
}
