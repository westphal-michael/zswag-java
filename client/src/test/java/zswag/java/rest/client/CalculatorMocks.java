package zswag.java.rest.client;

import java.io.IOException;
import java.math.BigInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import example.calculator.I32;
import zserio.runtime.io.ByteArrayBitStreamWriter;
import zswag.java.rest.api.ZserioCalculatorServiceInterface;

public class CalculatorMocks {

    public void setupMockPowerResponse(WireMockServer mockService, I32 request) throws IOException {
        example.calculator.Double response = new example.calculator.Double(
                BigInteger.valueOf(2).pow(request.getValue()).doubleValue());
        ByteArrayBitStreamWriter writer = new ByteArrayBitStreamWriter();
        response.write(writer, false);
        byte[] byteArray = writer.toByteArray();

        mockService.stubFor(WireMock.post(WireMock.urlEqualTo(ZserioCalculatorServiceInterface.POWER))
                .willReturn(WireMock.aResponse().withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_OCTET_STREAM_VALUE).withBody(byteArray)));
    }
}