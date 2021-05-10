package zswag.java.rest.openapi.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.http.converter.HttpMessageConverter;

public class FeignOpenApiEncoder extends SpringEncoder {

    static final private ObjectFactory<HttpMessageConverters> objectFactory = initObjectFactory();

    static private synchronized ObjectFactory<HttpMessageConverters> initObjectFactory() {
        if (objectFactory == null) {
            List<HttpMessageConverter<?>> httpMessageConverters = new ArrayList<HttpMessageConverter<?>>();
            httpMessageConverters.add(new SpringOpenApiHttpMessageConverter());
            return () -> new HttpMessageConverters(httpMessageConverters);
        }
        return objectFactory;
    }

    public FeignOpenApiEncoder() {
        super(objectFactory);
    }
}
