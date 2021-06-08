package zswag.java.rest.spring;

import java.util.Map;

import org.reactivestreams.Publisher;
import org.springframework.core.ResolvableType;
import org.springframework.core.codec.AbstractEncoder;
import org.springframework.core.codec.Hints;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.lang.Nullable;
import org.springframework.util.MimeType;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import zserio.runtime.io.InitializeOffsetsWriter;
import zserio.runtime.io.ZserioIO;

@Slf4j
public class SpringZserioByteArrayEncoder extends AbstractEncoder<InitializeOffsetsWriter> {

    public SpringZserioByteArrayEncoder() {
        super(SpringZserioHttpMessageConverter.MEDIATYPE_ZSERIO);
    }

    @Override
    public boolean canEncode(ResolvableType elementType, MimeType mimeType) {
        return (elementType != null) && (mimeType != null)
                && InitializeOffsetsWriter.class.isAssignableFrom(elementType.resolve())
                && getEncodableMimeTypes().contains(mimeType);
    }

    @Override
    public Flux<DataBuffer> encode(Publisher<? extends InitializeOffsetsWriter> inputStream,
            DataBufferFactory bufferFactory, ResolvableType elementType, @Nullable MimeType mimeType,
            @Nullable Map<String, Object> hints) {
        return Flux.from(inputStream).map(
                (InitializeOffsetsWriter value) -> encodeValue(value, bufferFactory, elementType, mimeType, hints));
    }

    @Override
    public DataBuffer encodeValue(InitializeOffsetsWriter value, DataBufferFactory bufferFactory,
            ResolvableType valueType, @Nullable MimeType mimeType, @Nullable Map<String, Object> hints) {
        if (value != null) {
            try {
                byte[] byteArray = ZserioIO.write((InitializeOffsetsWriter) value);
                DataBuffer dataBuffer = bufferFactory.wrap(byteArray);
                if (logger.isDebugEnabled() && !Hints.isLoggingSuppressed(hints)) {
                    String logPrefix = Hints.getLogPrefix(hints);
                    logger.debug(logPrefix + "Writing " + dataBuffer.readableByteCount() + " bytes");
                }
                return dataBuffer;
            } catch (Exception e) {
                e.printStackTrace();
                log.error("error reading stream data");
                return null;
            }
        }
        log.error("no input data found");
        return null;
    }
}