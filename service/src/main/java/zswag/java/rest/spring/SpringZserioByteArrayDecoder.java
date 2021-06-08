package zswag.java.rest.spring;

import java.util.Map;

import org.springframework.core.ResolvableType;
import org.springframework.core.codec.AbstractDataBufferDecoder;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.MimeType;

import lombok.extern.slf4j.Slf4j;
import zserio.runtime.io.InitializeOffsetsWriter;
import zserio.runtime.io.ZserioIO;

@Slf4j
public class SpringZserioByteArrayDecoder extends AbstractDataBufferDecoder<InitializeOffsetsWriter> {

    public SpringZserioByteArrayDecoder() {
        super(SpringZserioHttpMessageConverter.MEDIATYPE_ZSERIO);
    }

    @Override
    public boolean canDecode(ResolvableType elementType, @Nullable MimeType mimeType) {
        return (elementType != null) && (mimeType != null)
                && InitializeOffsetsWriter.class.isAssignableFrom(elementType.resolve())
                && getDecodableMimeTypes().contains(mimeType);
    }

    @Override
    public InitializeOffsetsWriter decode(DataBuffer dataBuffer, ResolvableType elementType,
            @Nullable MimeType mimeType, @Nullable Map<String, Object> hints) {
        try {
            byte[] byteArray = new byte[dataBuffer.readableByteCount()];
            dataBuffer.read(byteArray);
            DataBufferUtils.release(dataBuffer);
            InitializeOffsetsWriter result = (InitializeOffsetsWriter) ZserioIO.read(elementType.resolve(), byteArray);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error reading stream data");
            return null;
        }
    }
}
