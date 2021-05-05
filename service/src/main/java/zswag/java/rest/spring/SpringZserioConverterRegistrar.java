package zswag.java.rest.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.DecoderHttpMessageReader;
import org.springframework.http.codec.EncoderHttpMessageWriter;
import org.springframework.http.codec.HttpMessageReader;
import org.springframework.http.codec.HttpMessageWriter;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import lombok.Getter;
import zserio.runtime.io.InitializeOffsetsWriter;

@Configuration
public class SpringZserioConverterRegistrar implements WebFluxConfigurer {
    @Getter
    static private List<HttpMessageConverter<?>> additionalMessageConverters = initAdditionalMessageConverters();

    @Getter
    static private HttpMessageReader<InitializeOffsetsWriter> zserioHttpMessageReader = new DecoderHttpMessageReader<>(
            new SpringZserioByteArrayDecoder());

    @Getter
    static private HttpMessageWriter<InitializeOffsetsWriter> zserioHttpMessageWriter = new EncoderHttpMessageWriter<>(
            new SpringZserioByteArrayEncoder());

    static private synchronized List<HttpMessageConverter<?>> initAdditionalMessageConverters() {
        if (additionalMessageConverters == null) {
            additionalMessageConverters = new ArrayList<HttpMessageConverter<?>>();
            additionalMessageConverters.add(new SpringZserioHttpMessageConverter());
        }
        return additionalMessageConverters;
    }

    @Override
    public void configureHttpMessageCodecs(ServerCodecConfigurer configurer) {
        configurer.customCodecs().register(getZserioHttpMessageReader());
        configurer.customCodecs().register(getZserioHttpMessageWriter());
    }
}
