package zswag.java.rest.spring;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.lang.Nullable;
import org.springframework.util.StreamUtils;

import lombok.extern.slf4j.Slf4j;
import zserio.runtime.io.InitializeOffsetsWriter;
import zserio.runtime.io.ZserioIO;

@Slf4j
public class SpringZserioHttpMessageConverter extends AbstractHttpMessageConverter<InitializeOffsetsWriter> {

    public static final MediaType MEDIATYPE_ZSERIO = new MediaType("application", "x-zserio-object");
    public static final String MEDIATYPE_ZSERIO_VALUE = "application/x-zserio-object";

    public SpringZserioHttpMessageConverter() {
        super(MEDIATYPE_ZSERIO);
    }

    @Override
    protected Long getContentLength(InitializeOffsetsWriter value, @Nullable MediaType contentType) {
        long contentLength = 0L;
        try {
            byte[] byteArray = ZserioIO.write(value);
            contentLength = (long) byteArray.length;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error reading stream data");
        }
        return contentLength;
    }

    @Override
    protected InitializeOffsetsWriter readInternal(Class<? extends InitializeOffsetsWriter> clazz,
            HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        try {
            long contentLength = inputMessage.getHeaders().getContentLength();
            ByteArrayOutputStream bos = new ByteArrayOutputStream(
                    contentLength >= 0 ? (int) contentLength : StreamUtils.BUFFER_SIZE);
            StreamUtils.copy(inputMessage.getBody(), bos);
            byte[] byteArray = bos.toByteArray();

            InitializeOffsetsWriter value = ZserioIO.read(clazz, byteArray);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error reading stream data");
        }
        return null;
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return InitializeOffsetsWriter.class.isAssignableFrom(clazz);
    }

    @Override
    protected void writeInternal(InitializeOffsetsWriter value, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        try {
            byte[] byteArray = ZserioIO.write(value);
            StreamUtils.copy(byteArray, outputMessage.getBody());
        } catch (Exception e) {
            log.error("error writing stream data");
        }
    }
}
