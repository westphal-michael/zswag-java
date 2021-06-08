package zswag.java.rest.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import example.calculator.BaseAndExponent;
import example.calculator.Bool;
import example.calculator.Bools;
import example.calculator.Bytes;
import example.calculator.Doubles;
import example.calculator.EnumWrapper;
import example.calculator.Integers;
import example.calculator.Strings;
import zswag.java.rest.spring.SpringZserioHttpMessageConverter;

public interface ZserioCalculatorServiceInterface {

    public final static String BIT_MUL = "/bitMul";
    public final static String BYTE_SUM = "/byteSum";
    public final static String CONCAT = "/concat";
    public final static String FLOAT_MUL = "/floatMul";
    public final static String GET_BIT_MUL = "/getBitMul";
    public final static String GET_BYTE_SUM = "/getByteSum";
    public final static String GET_CONCAT = "/getConcat";
    public final static String GET_FLOAT_MUL = "/getFloatMul";
    public final static String GET_INT_MUL = "/getIntMul";
    public final static String GET_INT_SUM = "/getIntSum";
    public final static String GET_NAME = "/getName";
    public final static String GET_POWER = "/getPower";
    public final static String IDENTIFY = "/identify";
    public final static String INT_MUL = "/intMul";
    public final static String INT_SUM = "/intSum";
    public final static String NAME = "/name";
    public final static String POWER = "/power";
    public final static String PUT_IDENTIFY = "/putIdentify";
    public final static String PUT_IDENTIFY_JSON = "/putIdentifyJson";
    public final static String URL_BIT_MUL = "/bitMul/{values}";
    public final static String URL_BYTE_SUM = "/byteSum/{values}";
    public final static String URL_CONCAT = "/concat/{values}";
    public final static String URL_FLOAT_MUL = "/floatMul/{values}";
    public final static String URL_IDENTIFY = "/identify/{value}";
    public final static String URL_INT_MUL = "/intMul/{values}";
    public final static String URL_INT_SUM = "/intSum/{values}";
    public final static String URL_NAME = "/name/{value}";
    public final static String URL_POWER = "/power/{base}/{exponent}";

    // -------------------
    // POST binary methods
    @PostMapping(value = BIT_MUL, consumes = { SpringZserioHttpMessageConverter.MEDIATYPE_ZSERIO_VALUE }, produces = {
            SpringZserioHttpMessageConverter.MEDIATYPE_ZSERIO_VALUE })
    public ResponseEntity<Bool> bitMul(@RequestBody Bools request);

    @PostMapping(value = BYTE_SUM, consumes = { SpringZserioHttpMessageConverter.MEDIATYPE_ZSERIO_VALUE }, produces = {
            SpringZserioHttpMessageConverter.MEDIATYPE_ZSERIO_VALUE })
    public ResponseEntity<example.calculator.Double> byteSum(@RequestBody Bytes request);

    @PostMapping(value = CONCAT, consumes = { SpringZserioHttpMessageConverter.MEDIATYPE_ZSERIO_VALUE }, produces = {
            SpringZserioHttpMessageConverter.MEDIATYPE_ZSERIO_VALUE })
    public ResponseEntity<example.calculator.String> concat(@RequestBody Strings request);

    @PostMapping(value = FLOAT_MUL, consumes = { SpringZserioHttpMessageConverter.MEDIATYPE_ZSERIO_VALUE }, produces = {
            SpringZserioHttpMessageConverter.MEDIATYPE_ZSERIO_VALUE })
    public ResponseEntity<example.calculator.Double> floatMul(@RequestBody Doubles request);

    @PostMapping(value = IDENTIFY, consumes = { SpringZserioHttpMessageConverter.MEDIATYPE_ZSERIO_VALUE }, produces = {
            SpringZserioHttpMessageConverter.MEDIATYPE_ZSERIO_VALUE })
    public ResponseEntity<example.calculator.Double> identify(@RequestBody example.calculator.Double request);

    @PostMapping(value = INT_MUL, consumes = { SpringZserioHttpMessageConverter.MEDIATYPE_ZSERIO_VALUE }, produces = {
            SpringZserioHttpMessageConverter.MEDIATYPE_ZSERIO_VALUE })
    public ResponseEntity<example.calculator.Double> intMul(@RequestBody Integers request);

    @PostMapping(value = INT_SUM, consumes = { SpringZserioHttpMessageConverter.MEDIATYPE_ZSERIO_VALUE }, produces = {
            SpringZserioHttpMessageConverter.MEDIATYPE_ZSERIO_VALUE })
    public ResponseEntity<example.calculator.Double> intSum(@RequestBody Integers request);

    @PostMapping(value = NAME, consumes = { SpringZserioHttpMessageConverter.MEDIATYPE_ZSERIO_VALUE }, produces = {
            SpringZserioHttpMessageConverter.MEDIATYPE_ZSERIO_VALUE })
    public ResponseEntity<example.calculator.String> name(@RequestBody EnumWrapper request);

    @PostMapping(value = POWER, consumes = { SpringZserioHttpMessageConverter.MEDIATYPE_ZSERIO_VALUE }, produces = {
            SpringZserioHttpMessageConverter.MEDIATYPE_ZSERIO_VALUE })
    public ResponseEntity<example.calculator.Double> power(@RequestBody BaseAndExponent baseAndExponent);

    // -----------------------------
    // GET request parameter methods
    @GetMapping(value = GET_BIT_MUL, produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> getBitMul(@RequestParam("values") List<Boolean> request);

    @GetMapping(value = GET_BYTE_SUM, produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> getByteSum(@RequestParam("values") List<Byte> request);

    @GetMapping(value = GET_CONCAT, produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> getConcat(@RequestParam("values") List<String> request);

    @GetMapping(value = GET_FLOAT_MUL, produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> getFloatMul(@RequestParam("values") List<Double> request);

    @GetMapping(value = GET_INT_MUL, produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> getIntMul(@RequestParam("values") List<Integer> request);

    @GetMapping(value = GET_INT_SUM, produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> getIntSum(@RequestParam("values") List<Integer> request);

    @GetMapping(value = GET_NAME, produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> getName(@RequestParam("value") Integer request);

    @GetMapping(value = GET_POWER, produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> getPower(@RequestParam("base") Integer base,
            @RequestParam("exponent") Integer exponent);

    @PutMapping(value = PUT_IDENTIFY, produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> putIdentify(@RequestParam("value") Double request);

    @PutMapping(value = PUT_IDENTIFY_JSON, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> putIdentifyJson(@RequestParam("value") Double request);

    // --------------------------
    // GET path parameter methods
    @GetMapping(value = URL_BIT_MUL, produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> urlGetBitMul(@PathVariable("values") List<Boolean> request);

    @GetMapping(value = URL_BYTE_SUM, produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> urlGetByteSum(@PathVariable("values") List<Byte> request);

    @GetMapping(value = URL_CONCAT, produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> urlGetConcat(@PathVariable("values") List<String> request);

    @GetMapping(value = URL_FLOAT_MUL, produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> urlGetFloatMul(@PathVariable("values") List<Double> request);

    @GetMapping(value = URL_INT_MUL, produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> urlGetIntMul(@PathVariable("values") List<Integer> request);

    @GetMapping(value = URL_INT_SUM, produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> urlGetIntSum(@PathVariable("values") List<Integer> request);

    @GetMapping(value = URL_NAME, produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> urlGetName(@PathVariable("value") Integer request);

    @GetMapping(value = URL_POWER, produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> urlGetPower(@PathVariable("base") Integer base,
            @PathVariable("exponent") Integer exponent);

    @PutMapping(value = URL_IDENTIFY, produces = { MediaType.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> urlPutIdentify(@PathVariable("value") Double request);

}
