/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client.serialize;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

/**
 *
 * @author Charalampos Chomenidis
 * @author Pantelis Karatzas
 */
public interface Serializer extends Closeable {
    
    public boolean isClosed();

    public void write(Object entity, OutputStream out);

    public void write(Object entity, Writer writer);

    public String write(Object entity);

    public <T> T parse(String content, Class<T> valueType);

    public <T> T parse(InputStream src, Class<T> valueType);

    public <T> T parse(InputStream src, TypeReference<T> valueType);

}
