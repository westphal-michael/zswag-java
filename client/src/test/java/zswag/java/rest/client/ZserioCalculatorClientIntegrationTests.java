package zswag.java.rest.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;
import java.math.BigInteger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.github.tomakehurst.wiremock.WireMockServer;

import example.calculator.I32;

@ActiveProfiles("test")
@ContextConfiguration(classes = { ZserioCalculatorClientApplication.class, WireMockConfig.class })
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@TestInstance(Lifecycle.PER_CLASS)
public class ZserioCalculatorClientIntegrationTests {

    private final static I32 EXPONENT_POWER_REQUEST_I32 = new I32(5);
    private final static example.calculator.Double POWER_RESPONSE_DOUBLE = new example.calculator.Double(
            BigInteger.valueOf(2).pow(EXPONENT_POWER_REQUEST_I32.getValue()).doubleValue());

    @Autowired
    private ZserioCalculatorClientController controller;

    @Autowired
    private WireMockServer wireMockServer;

    private CalculatorMocks mocks;

    @BeforeAll
    private void setUp() throws IOException {
        mocks = new CalculatorMocks();
        mocks.setupMockPowerResponse(wireMockServer, EXPONENT_POWER_REQUEST_I32);
    }

    @Test
    public void spth() throws Exception {
        assert (wireMockServer != null);
        assert (mocks != null);
        assert (controller != null);
    }

    @Test
    public void testPowerOfTwoCorrectValues() {
        example.calculator.Double returnValue = controller.powerOfTwo(EXPONENT_POWER_REQUEST_I32);
        assertEquals(POWER_RESPONSE_DOUBLE.getValue(), returnValue.getValue());
    }

    @Test
    public void testPowerOfTwoIncorrectValues() {
        example.calculator.Double compareValue = new example.calculator.Double(POWER_RESPONSE_DOUBLE.getValue() + 1.0);
        example.calculator.Double returnValue = controller.powerOfTwo(EXPONENT_POWER_REQUEST_I32);
        assertNotEquals(compareValue.getValue(), returnValue.getValue());
    }
}