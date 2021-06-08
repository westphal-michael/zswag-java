package zswag.java.rest.client;

import java.io.IOException;
import java.math.BigInteger;

import org.springframework.http.HttpStatus;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import example.calculator.Double;
import example.calculator.I32;
import zserio.runtime.io.ByteArrayBitStreamWriter;
import zswag.java.rest.api.ZserioCalculatorServiceInterface;
import zswag.java.rest.spring.SpringZserioHttpMessageConverter;

public class CalculatorMocks {

    public void setupMockPowerResponse(WireMockServer mockService, I32 request) throws IOException {
        Double response = new Double(BigInteger.valueOf(2).pow(request.getValue()).doubleValue());
        ByteArrayBitStreamWriter writer = new ByteArrayBitStreamWriter();
        response.write(writer, false);
        byte[] byteArray = writer.toByteArray();

        mockService.stubFor(WireMock.post(WireMock.urlEqualTo(ZserioCalculatorServiceInterface.POWER))
                .willReturn(WireMock.aResponse().withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", SpringZserioHttpMessageConverter.MEDIATYPE_ZSERIO_VALUE).withBody(byteArray)));
    }
}