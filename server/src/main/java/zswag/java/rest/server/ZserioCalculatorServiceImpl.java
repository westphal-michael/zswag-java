package zswag.java.rest.server;

import example.calculator.BaseAndExponent;
import example.calculator.Bool;
import example.calculator.Bools;
import example.calculator.Bytes;
import example.calculator.Calculator.CalculatorService;
import example.calculator.Doubles;
import example.calculator.EnumWrapper;
import example.calculator.Integers;
import example.calculator.Strings;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ZserioCalculatorServiceImpl extends CalculatorService {

    @Override
    protected Bool bitMulImpl(Bools request, Object context) {
        Bool returnValue = null;
        if (request != null) {
            boolean[] values = request.getValues();
            boolean product = true;
            for (Boolean value : values) {
                product &= value;
            }
            returnValue = new Bool(product);
        }
        log.info("bitMul({}) = {}", request.getValues(), returnValue.getValue());
        return returnValue;
    }

    @Override
    protected example.calculator.Double byteSumImpl(Bytes request, Object context) {
        example.calculator.Double returnValue = null;
        if (request != null) {
            short[] values = request.getValues();
            double sum = 0;
            for (Short value : values) {
                sum += value;
            }
            returnValue = new example.calculator.Double(sum);
        }
        log.info("byteSum({}) = {}", request.getValues(), returnValue.getValue());
        return returnValue;
    }

    @Override
    protected example.calculator.String concatImpl(Strings request, Object context) {
        example.calculator.String returnValue = null;
        if (request != null) {
            String[] values = request.getValues();
            java.lang.String temp = "";
            for (java.lang.String value : values) {
                temp += value;
            }

            returnValue = new example.calculator.String(temp);
        }
        log.info("concat({}) = {}", request.getValues(), returnValue.getValue());
        return returnValue;
    }

    @Override
    protected example.calculator.Double floatMulImpl(Doubles request, Object context) {
        example.calculator.Double returnValue = null;
        if (request != null) {
            double[] values = request.getValues();
            double product = 1;
            for (Double value : values) {
                product *= (double) value;
            }
            returnValue = new example.calculator.Double(product);
        }
        log.info("floatMul({}) = {}", request.getValues(), returnValue.getValue());
        return returnValue;
    }

    @Override
    protected example.calculator.Double identityImpl(example.calculator.Double request, Object context) {
        log.info("identify({}) = {}", request.getValue(), request.getValue());
        return request;
    }

    @Override
    protected example.calculator.Double intMulImpl(Integers request, Object context) {
        example.calculator.Double returnValue = null;
        if (request != null) {
            int[] values = request.getValues();
            double product = 1;
            for (Integer value : values) {
                product *= (double) value;
            }
            returnValue = new example.calculator.Double(product);
        }
        log.info("intMul({}) = {}", request.getValues(), returnValue.getValue());
        return returnValue;
    }

    @Override
    protected example.calculator.Double intSumImpl(Integers request, Object context) {
        example.calculator.Double returnValue = null;
        if (request != null) {
            int[] values = request.getValues();
            double sum = 0;
            for (Integer value : values) {
                sum += value;
            }
            returnValue = new example.calculator.Double(sum);
        }
        log.info("intSum({}) = {}", request.getValues(), returnValue.getValue());
        return returnValue;
    }

    @Override
    protected example.calculator.String nameImpl(EnumWrapper request, Object context) {
        example.calculator.String returnValue = null;
        if (request != null) {
            returnValue = new example.calculator.String(request.getValue().name());
        }
        log.info("name({}) = {}", request.getValue().getValue(), returnValue.getValue());
        return returnValue;
    }

    @Override
    protected example.calculator.Double powerImpl(BaseAndExponent request, Object context) {
        example.calculator.Double returnValue = null;
        if (request != null) {
            double value = Math.pow(request.getBase().getValue(), request.getExponent().getValue());
            returnValue = new example.calculator.Double(value);
        }
        log.info("power({},{}) = {}", request.getBase().getValue(), request.getExponent().getValue(),
                returnValue.getValue());
        return returnValue;
    }
}
