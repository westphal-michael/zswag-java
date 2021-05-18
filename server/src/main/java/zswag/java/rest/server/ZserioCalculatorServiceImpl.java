package zswag.java.rest.server;

import java.util.ArrayList;
import java.util.List;

import example.calculator.BaseAndExponent;
import example.calculator.Bool;
import example.calculator.Bools;
import example.calculator.Bytes;
import example.calculator.Calculator.CalculatorService;
import example.calculator.Double;
import example.calculator.Doubles;
import example.calculator.EnumWrapper;
import example.calculator.Integers;
import example.calculator.String;
import example.calculator.Strings;
import lombok.extern.slf4j.Slf4j;
import zserio.runtime.array.UnsignedByteArray;

@Slf4j
public class ZserioCalculatorServiceImpl extends CalculatorService {
    @Override
    protected Bool bitMulImpl(Bools request, Object context) {
        Bool returnValue = null;
        if (request != null) {
            zserio.runtime.array.BoolArray values = request.getValues();
            boolean product = true;
            for (Boolean value : values) {
                product &= value;
            }
            returnValue = new Bool(product);
        }
        List<java.lang.String> values = new ArrayList<>();
        request.getValues().iterator().forEachRemaining(value -> values.add(java.lang.String.valueOf(value)));
        log.info("bitMul({}) = {}", values, returnValue.getValue());
        return returnValue;
    }

    @Override
    protected Double byteSumImpl(Bytes request, Object context) {
        Double returnValue = null;
        if (request != null) {
            UnsignedByteArray values = request.getValues();
            double sum = 0;
            for (Short value : values) {
                sum += value;
            }
            returnValue = new Double(sum);
        }
        List<java.lang.String> values = new ArrayList<>();
        request.getValues().iterator().forEachRemaining(value -> values.add(java.lang.String.valueOf(value)));
        log.info("byteSum({}) = {}", values, returnValue.getValue());
        return returnValue;
    }

    @Override
    protected String concatImpl(Strings request, Object context) {
        String returnValue = null;
        if (request != null) {
            zserio.runtime.array.StringArray values = request.getValues();
            java.lang.String temp = "";
            for (java.lang.String value : values) {
                temp += value;
            }

            returnValue = new String(temp);
        }
        List<java.lang.String> values = new ArrayList<>();
        request.getValues().iterator().forEachRemaining(value -> values.add(java.lang.String.valueOf(value)));
        log.info("concat({}) = {}", values, returnValue.getValue());
        return returnValue;
    }

    @Override
    protected Double floatMulImpl(Doubles request, Object context) {
        Double returnValue = null;
        if (request != null) {
            zserio.runtime.array.Float64Array values = request.getValues();
            double product = 1;
            for (java.lang.Double value : values) {
                product *= (double) value;
            }
            returnValue = new Double(product);
        }
        List<java.lang.String> values = new ArrayList<>();
        request.getValues().iterator().forEachRemaining(value -> values.add(java.lang.String.valueOf(value)));
        log.info("floatMul({}) = {}", values, returnValue.getValue());
        return returnValue;
    }

    @Override
    protected Double identityImpl(Double request, Object context) {
        log.info("identify({}) = {}", request.getValue(), request.getValue());
        return request;
    }

    @Override
    protected Double intMulImpl(Integers request, Object context) {
        Double returnValue = null;
        if (request != null) {
            zserio.runtime.array.IntArray values = request.getValues();
            double product = 1;
            for (Integer value : values) {
                product *= (double) value;
            }
            returnValue = new Double(product);
        }
        List<java.lang.String> values = new ArrayList<>();
        request.getValues().iterator().forEachRemaining(value -> values.add(java.lang.String.valueOf(value)));
        log.info("intMul({}) = {}", values, returnValue.getValue());
        return returnValue;
    }

    @Override
    protected Double intSumImpl(Integers request, Object context) {
        Double returnValue = null;
        if (request != null) {
            zserio.runtime.array.IntArray values = request.getValues();
            double sum = 0;
            for (Integer value : values) {
                sum += value;
            }
            returnValue = new Double(sum);
        }
        List<java.lang.String> values = new ArrayList<>();
        request.getValues().iterator().forEachRemaining(value -> values.add(java.lang.String.valueOf(value)));
        log.info("intSum({}) = {}", values, returnValue.getValue());
        return returnValue;
    }

    @Override
    protected String nameImpl(EnumWrapper request, Object context) {
        String returnValue = null;
        if (request != null) {
            returnValue = new String(request.getValue().name());
        }
        log.info("name({}) = {}", request.getValue().getValue(), returnValue.getValue());
        return returnValue;
    }

    @Override
    protected Double powerImpl(BaseAndExponent request, Object context) {
        Double returnValue = null;
        if (request != null) {
            double value = Math.pow(request.getBase().getValue(), request.getExponent().getValue());
            returnValue = new Double(value);
        }
        log.info("power({},{}) = {}", request.getBase().getValue(), request.getExponent().getValue(),
                returnValue.getValue());
        return returnValue;
    }
}
