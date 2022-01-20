package zswag.java.rest.server;

import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import example.calculator.BaseAndExponent;
import example.calculator.Bool;
import example.calculator.Bools;
import example.calculator.Bytes;
import example.calculator.Doubles;
import example.calculator.EnumWrapper;
import example.calculator.I32;
import example.calculator.Integers;
import example.calculator.Strings;
import lombok.extern.slf4j.Slf4j;
import nonapi.io.github.classgraph.json.JSONSerializer;
import zserio.runtime.ZserioError;
import zswag.java.rest.api.ZserioCalculatorServiceInterface;

@RestController
@ControllerAdvice
@Slf4j
public class ZserioCalculatorServerController implements ZserioCalculatorServiceInterface {
    private ZserioCalculatorServiceImpl calculatorServiceImpl = new ZserioCalculatorServiceImpl();

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleAnyException(RuntimeException exception) {
        return "server exception: " + exception.getMessage();
    }

    // -------------------
    // POST binary methods
    @Override
    public ResponseEntity<Bool> bitMul(Bools request) {
        if (request != null) {
            try {
                Bool result = calculatorServiceImpl.bitMulImpl(request, null);
                return ResponseEntity.ok().body(result);
            } catch (ZserioError e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
        String message = "no or invalid request data";
        log.warn(message);
        return ResponseEntity.noContent().header("error", message).build();
    }

    @Override
    public ResponseEntity<example.calculator.Double> byteSum(Bytes request) {
        if (request != null) {
            try {
                example.calculator.Double result = calculatorServiceImpl.byteSumImpl(request, null);
                return ResponseEntity.ok().body(result);
            } catch (ZserioError e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
        String message = "no or invalid request data";
        log.warn(message);
        return ResponseEntity.noContent().header("error", message).build();
    }

    @Override
    public ResponseEntity<example.calculator.String> concat(Strings request) {
        if (request != null) {
            try {
                example.calculator.String result = calculatorServiceImpl.concatImpl(request, null);
                return ResponseEntity.ok().body(result);
            } catch (ZserioError e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
        String message = "no or invalid request data";
        log.warn(message);
        return ResponseEntity.noContent().header("error", message).build();
    }

    @Override
    public ResponseEntity<example.calculator.Double> floatMul(Doubles request) {
        if (request != null) {
            try {
                example.calculator.Double result = calculatorServiceImpl.floatMulImpl(request, null);
                return ResponseEntity.ok().body(result);
            } catch (ZserioError e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
        String message = "no or invalid request data";
        log.warn(message);
        return ResponseEntity.noContent().header("error", message).build();
    }

    @Override
    public ResponseEntity<example.calculator.Double> identify(example.calculator.Double request) {
        if (request != null) {
            try {
                example.calculator.Double result = calculatorServiceImpl.identityImpl(request, null);
                return ResponseEntity.ok().body(result);
            } catch (ZserioError e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
        String message = "no or invalid request data";
        log.warn(message);
        return ResponseEntity.noContent().header("error", message).build();
    }

    @Override
    public ResponseEntity<example.calculator.Double> intMul(Integers request) {
        if (request != null) {
            try {
                example.calculator.Double result = calculatorServiceImpl.intMulImpl(request, null);
                return ResponseEntity.ok().body(result);
            } catch (ZserioError e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
        String message = "no or invalid request data";
        log.warn(message);
        return ResponseEntity.noContent().header("error", message).build();
    }

    @Override
    public ResponseEntity<example.calculator.Double> intSum(Integers request) {
        if (request != null) {
            try {
                example.calculator.Double result = calculatorServiceImpl.intSumImpl(request, null);
                return ResponseEntity.ok().body(result);
            } catch (ZserioError e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
        String message = "no or invalid request data";
        log.warn(message);
        return ResponseEntity.noContent().header("error", message).build();
    }

    @Override
    public ResponseEntity<example.calculator.String> name(EnumWrapper request) {
        if (request != null) {
            try {
                example.calculator.String result = calculatorServiceImpl.nameImpl(request, null);
                return ResponseEntity.ok().body(result);
            } catch (ZserioError e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
        String message = "no or invalid request data";
        log.warn(message);
        return ResponseEntity.noContent().header("error", message).build();
    }

    @Override
    public ResponseEntity<example.calculator.Double> power(BaseAndExponent baseAndExponent) {
        if ((baseAndExponent != null) && (baseAndExponent.getBase() != null)
                && (baseAndExponent.getExponent() != null)) {
            try {
                example.calculator.Double result = calculatorServiceImpl.powerImpl(baseAndExponent, null);
                return ResponseEntity.ok().body(result);
            } catch (ZserioError e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
        String message = "no or invalid request data";
        log.warn(message);
        return ResponseEntity.noContent().header("error", message).build();
    }

    // -----------------------------
    // GET request parameter methods
    @Override
    public ResponseEntity<String> getBitMul(List<Boolean> request) {
        if (request == null) {
            return null;
        }
        boolean[] array = new boolean[request.size()];
        int index = 0;
        for (Iterator<Boolean> iterator = request.iterator(); iterator.hasNext();) {
            Boolean value = (Boolean) iterator.next();
            array[index++] = value.booleanValue();
        }
        ResponseEntity<Bool> response = bitMul(new Bools(array));
        String value = (response.getBody() != null) ? "" + response.getBody().getValue() : "";
        return new ResponseEntity<String>(value, response.getHeaders(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<String> getByteSum(List<Byte> request) {
        if (request == null) {
            return null;
        }
        short[] array = new short[request.size()];
        int index = 0;
        for (Iterator<Byte> iterator = request.iterator(); iterator.hasNext();) {
            Byte value = (Byte) iterator.next();
            array[index++] = value.byteValue();
        }
        ResponseEntity<example.calculator.Double> response = byteSum(new Bytes(array));
        String value = (response.getBody() != null) ? "" + response.getBody().getValue() : "";
        return new ResponseEntity<String>(value, response.getHeaders(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<String> getConcat(List<String> request) {
        if (request == null) {
            return null;
        }
        String[] array = new String[request.size()];
        int index = 0;
        for (Iterator<String> iterator = request.iterator(); iterator.hasNext();) {
            String value = (String) iterator.next();
            array[index++] = value;
        }
        ResponseEntity<example.calculator.String> response = concat(new Strings(array));
        String value = (response.getBody() != null) ? response.getBody().getValue() : "";
        return new ResponseEntity<String>(value, response.getHeaders(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<String> getFloatMul(List<Double> request) {
        if (request == null) {
            return null;
        }
        double[] array = new double[request.size()];
        int index = 0;
        for (Iterator<java.lang.Double> iterator = request.iterator(); iterator.hasNext();) {
            java.lang.Double value = (java.lang.Double) iterator.next();
            array[index++] = value.doubleValue();
        }
        ResponseEntity<example.calculator.Double> response = floatMul(new Doubles(array));
        String value = (response.getBody() != null) ? "" + response.getBody().getValue() : "";
        return new ResponseEntity<String>(value, response.getHeaders(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<String> getIntMul(List<Integer> request) {
        if (request == null) {
            return null;
        }
        int[] array = new int[request.size()];
        int index = 0;
        for (Iterator<Integer> iterator = request.iterator(); iterator.hasNext();) {
            Integer value = (Integer) iterator.next();
            array[index++] = value.intValue();
        }
        ResponseEntity<example.calculator.Double> response = intMul(new Integers(array));
        String value = (response.getBody() != null) ? "" + response.getBody().getValue() : "";
        return new ResponseEntity<String>(value, response.getHeaders(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<String> getIntSum(List<Integer> request) {
        if (request == null) {
            return null;
        }
        int[] array = new int[request.size()];
        int index = 0;
        for (Iterator<Integer> iterator = request.iterator(); iterator.hasNext();) {
            Integer value = (Integer) iterator.next();
            array[index++] = value.intValue();
        }
        ResponseEntity<example.calculator.Double> response = intSum(new Integers(array));
        String value = (response.getBody() != null) ? "" + response.getBody().getValue() : "";
        return new ResponseEntity<String>(value, response.getHeaders(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<String> getName(Integer request) {
        EnumWrapper enumWrapper = null;
        if (request != null) {
            example.calculator.Enum value = example.calculator.Enum.toEnum(request.intValue());
            enumWrapper = new EnumWrapper(value);
        }
        ResponseEntity<example.calculator.String> response = name(enumWrapper);
        String value = (response.getBody() != null) ? response.getBody().getValue() : "";
        return new ResponseEntity<String>(value, response.getHeaders(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<String> getPower(Integer base, Integer exponent) {
        BaseAndExponent baseAndExponent = new BaseAndExponent(new I32(base.intValue()), new I32(exponent.intValue()), 0,
                BIT_MUL, 0, null);
        ResponseEntity<example.calculator.Double> response = power(baseAndExponent);
        String value = (response.getBody() != null) ? "" + response.getBody().getValue() : "";
        return new ResponseEntity<String>(value, response.getHeaders(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<String> putIdentify(Double request) {
        ResponseEntity<example.calculator.Double> response = identify(
                new example.calculator.Double(request.doubleValue()));
        String value = (response.getBody() != null) ? "" + response.getBody().getValue() : "";
        return new ResponseEntity<String>(value, response.getHeaders(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<String> putIdentifyJson(Double request) {
        ResponseEntity<example.calculator.Double> response = identify(
                new example.calculator.Double(request.doubleValue()));
        String value = JSONSerializer.serializeObject(response.getBody());
        return new ResponseEntity<String>(value, response.getHeaders(), response.getStatusCode());
    }

    // --------------------------
    // GET path parameter methods
    @Override
    public ResponseEntity<String> urlGetBitMul(List<Boolean> request) {
        return getBitMul(request);
    }

    @Override
    public ResponseEntity<String> urlGetByteSum(List<Byte> request) {
        return getByteSum(request);
    }

    @Override
    public ResponseEntity<String> urlGetConcat(List<String> request) {
        return getConcat(request);
    }

    @Override
    public ResponseEntity<String> urlGetFloatMul(List<Double> request) {
        return getFloatMul(request);
    }

    @Override
    public ResponseEntity<String> urlGetIntMul(List<Integer> request) {
        return getIntMul(request);
    }

    @Override
    public ResponseEntity<String> urlGetIntSum(List<Integer> request) {
        return getIntSum(request);
    }

    @Override
    public ResponseEntity<String> urlGetName(Integer request) {
        return getName(request);
    }

    @Override
    public ResponseEntity<String> urlGetPower(Integer base, Integer exponent) {
        return getPower(base, exponent);
    }

    @Override
    public ResponseEntity<String> urlPutIdentify(Double request) {
        return putIdentify(request);
    }
}
