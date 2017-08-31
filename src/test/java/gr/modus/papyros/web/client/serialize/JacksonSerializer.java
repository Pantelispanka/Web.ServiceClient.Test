/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;

/**
 *
 * @author Charalampos Chomenidis
 * @author Pantelis Karatzas
 */
public class JacksonSerializer implements Serializer {

    private final ObjectMapper mapper;
    private boolean isClosed;

    public JacksonSerializer(ObjectMapper mapper) {
        isClosed = false;
        this.mapper = mapper;
        mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
        mapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"));
    }

    @Override
    public boolean isClosed() {
        return isClosed;
    }

    @Override
    public void write(Object entity, OutputStream out) {
        try {
            mapper.writeValue(out, entity);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }   

    @Override
    public void write(Object entity, Writer writer) {
        try {
            mapper.writeValue(writer, entity);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String write(Object entity) {
        try {
            return mapper.writeValueAsString(entity);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public <T> T parse(String content, Class<T> valueType) {
        try {
            return mapper.readValue(content, valueType);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public <T> T parse(InputStream src, Class<T> valueType) {
        try {
            return mapper.readValue(src, valueType);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public <T> T parse(InputStream src, TypeReference<T> valueType) {
        try {
            return mapper.readValue(src, new com.fasterxml.jackson.core.type.TypeReference<T>() {
                @Override
                public Type getType() {
                    return valueType.getType();
                }

            });
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void close() throws IOException {
        this.isClosed = true;
    }

}
