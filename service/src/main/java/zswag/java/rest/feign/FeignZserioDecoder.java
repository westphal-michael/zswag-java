package zswag.java.rest.feign;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;

import zswag.java.rest.spring.SpringZserioConverterRegistrar;

public class FeignZserioDecoder extends ResponseEntityDecoder {

    static final private ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(
            SpringZserioConverterRegistrar.getAdditionalMessageConverters());

    @SuppressWarnings("deprecation")
    public FeignZserioDecoder() {
        super(new SpringDecoder(objectFactory));
    }
}
