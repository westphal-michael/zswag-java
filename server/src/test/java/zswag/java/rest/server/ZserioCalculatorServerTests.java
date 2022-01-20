package zswag.java.rest.server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import example.calculator.BaseAndExponent;
import example.calculator.Double;
import example.calculator.I32;

@ActiveProfiles("test")
@ContextConfiguration(classes = ZserioCalculatorServerApplication.class)
@EnableFeignClients
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ZserioCalculatorServerTests {
    @Autowired
    private ZserioCalculatorServiceTestClient client;

    @Test
    public void contextLoads() {
        assert (client != null);
    }

    @Test
    public void testGetPowerCorrectValues() {
        Integer base = Integer.valueOf(5);
        Integer exponent = Integer.valueOf(2);
        double value = Math.pow(base, exponent);
        ResponseEntity<String> response = client.getPower(base, exponent);
        assert (response.getStatusCode().equals(HttpStatus.OK));
        assert (String.valueOf(value).equals(response.getBody()));
    }

    @Test
    public void testGetPowerIncorrectValues() {
        Integer base = Integer.valueOf(5);
        Integer exponent = Integer.valueOf(2);
        double value = Math.pow(base, exponent);
        value += 1.0;
        ResponseEntity<String> response = client.getPower(base, exponent);
        assert (response.getStatusCode().equals(HttpStatus.OK));
        assert (!String.valueOf(value).equals(response.getBody()));
    }

    @Test
    public void testPostIdentifyCorrectValues() {
        Double request = new Double(123.45);
        ResponseEntity<Double> response = client.identify(request);
        assert (response.getStatusCode().equals(HttpStatus.OK));
        assert (request.equals(response.getBody()));
    }

    @Test
    public void testPostPowerCorrectValues() {
        BaseAndExponent request = new BaseAndExponent(new I32(5), new I32(2), 0, "", 0, new boolean[0]);
        Double value = new Double(25.0);
        ResponseEntity<Double> response = client.power(request);
        assert (response.getStatusCode().equals(HttpStatus.OK));
        assert (value.equals(response.getBody()));
    }

    @Test
    public void testPostPowerIncorrectValues() {
        BaseAndExponent request = new BaseAndExponent(new I32(5), new I32(2), 0, "", 0, new boolean[0]);
        Double value = new Double(1.0);
        ResponseEntity<Double> response = client.power(request);
        assert (response.getStatusCode().equals(HttpStatus.OK));
        assert (!value.equals(response.getBody()));
    }
}
