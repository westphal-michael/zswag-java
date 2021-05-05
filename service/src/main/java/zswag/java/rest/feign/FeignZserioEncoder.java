package zswag.java.rest.feign;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;

import zswag.java.rest.spring.SpringZserioConverterRegistrar;

public class FeignZserioEncoder extends SpringEncoder {

    static final private ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(
            SpringZserioConverterRegistrar.getAdditionalMessageConverters());

    public FeignZserioEncoder() {
        super(objectFactory);
    }
}
