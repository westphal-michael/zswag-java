package zswag.java.rest.openapi.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import example.calculator.BaseAndExponent;
import example.calculator.I32;
import lombok.extern.slf4j.Slf4j;
import zserio.runtime.array.BoolArray;
import zserio.runtime.io.InitializeOffsetsWriter;
import zserio.runtime.io.ZserioIO;
import zswag.java.rest.openapi.model.BaseAndExponentOpenApi;
import zswag.java.rest.openapi.model.DoubleOpenApi;
import zswag.java.rest.openapi.model.I32OpenApi;
import zswag.java.rest.openapi.model.StringOpenApi;
import zswag.java.rest.spring.SpringZserioHttpMessageConverter;

@Slf4j
public class SpringOpenApiHttpMessageConverter extends AbstractHttpMessageConverter<Object> {

    public SpringOpenApiHttpMessageConverter() {
        super(SpringZserioHttpMessageConverter.MEDIATYPE_ZSERIO);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.getPackageName().equals("zswag.java.rest.openapi.model");
    }

    @Override
    protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {
        try {
            long contentLength = inputMessage.getHeaders().getContentLength();
            ByteArrayOutputStream bos = new ByteArrayOutputStream(
                    contentLength >= 0 ? (int) contentLength : StreamUtils.BUFFER_SIZE);
            StreamUtils.copy(inputMessage.getBody(), bos);
            byte[] byteArray = bos.toByteArray();
            Object returnValue = null;
            switch (clazz.getSimpleName()) {
            case "BaseAndExponentOpenApi":
                BaseAndExponent baseAndExponent = ZserioIO.read(BaseAndExponent.class, byteArray);
                returnValue = new BaseAndExponentOpenApi();
                I32OpenApi base = new I32OpenApi();
                base.setValue(baseAndExponent.getBase().getValue());
                I32OpenApi exponent = new I32OpenApi();
                exponent.setValue(baseAndExponent.getExponent().getValue());
                ((BaseAndExponentOpenApi) returnValue).setBase(base);
                ((BaseAndExponentOpenApi) returnValue).setExponent(exponent);
                break;
            case "DoubleOpenApi":
                example.calculator.Double doubleZserio = ZserioIO.read(example.calculator.Double.class, byteArray);
                returnValue = new DoubleOpenApi();
                ((DoubleOpenApi) returnValue).setValue(doubleZserio.getValue());
                break;
            case "I32OpenApi":
                I32 i32 = ZserioIO.read(I32.class, byteArray);
                returnValue = new I32OpenApi();
                ((I32OpenApi) returnValue).setValue(i32.getValue());
                break;
            case "StringOpenApi":
                example.calculator.String stringZserio = ZserioIO.read(example.calculator.String.class, byteArray);
                returnValue = new StringOpenApi();
                ((StringOpenApi) returnValue).setValue(stringZserio.getValue());
                break;
            default:
                break;
            }
            return returnValue;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error reading stream data");
        }
        return null;
    }

    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        try {
            InitializeOffsetsWriter value = null;
            switch (object.getClass().getSimpleName()) {
            case "BaseAndExponentOpenApi":
                example.calculator.I32 base = new example.calculator.I32(
                        ((BaseAndExponentOpenApi) object).getBase().getValue());
                example.calculator.I32 exponent = new example.calculator.I32(
                        ((BaseAndExponentOpenApi) object).getExponent().getValue());
                value = new BaseAndExponent(base, exponent, 0, "", 0, new BoolArray(0));
                break;
            case "DoubleOpenApi":
                value = new example.calculator.Double(((DoubleOpenApi) object).getValue().doubleValue());
                break;
            case "I32OpenApi":
                value = new example.calculator.I32(((I32OpenApi) object).getValue().intValue());
                break;
            case "StringOpenApi":
                value = new example.calculator.String(((StringOpenApi) object).getValue());
                break;
            default:
                break;
            }
            byte[] byteArray = ZserioIO.write(value);
            StreamUtils.copy(byteArray, outputMessage.getBody());
        } catch (Exception e) {
            log.error("error writing stream data");
        }
    }
}