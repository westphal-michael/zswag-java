package zswag.java.rest.openapi.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.http.converter.HttpMessageConverter;

public class FeignOpenApiDecoder extends ResponseEntityDecoder {

    static final private ObjectFactory<HttpMessageConverters> objectFactory = initObjectFactory();

    static private synchronized ObjectFactory<HttpMessageConverters> initObjectFactory() {
        if (objectFactory == null) {
            List<HttpMessageConverter<?>> httpMessageConverters = new ArrayList<HttpMessageConverter<?>>();
            httpMessageConverters.add(new SpringOpenApiHttpMessageConverter());
            return () -> new HttpMessageConverters(httpMessageConverters);
        }
        return objectFactory;
    }

    @SuppressWarnings("deprecation")
    public FeignOpenApiDecoder() {
        super(new SpringDecoder(objectFactory));
    }
}
