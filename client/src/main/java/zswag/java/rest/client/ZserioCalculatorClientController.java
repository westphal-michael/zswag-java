package zswag.java.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import example.calculator.BaseAndExponent;
import example.calculator.Double;
import example.calculator.I32;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ZserioCalculatorClientController {
    @Autowired
    private ZserioCalculatorServiceClient client;

    public Double powerOfTwo(I32 exponent) {
        return power(new I32(2), exponent);
    }

    public Double power(I32 base, I32 exponent) {
        BaseAndExponent baseAndExponent = new BaseAndExponent(base, exponent, 0, "", 0, new boolean[0]);
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
