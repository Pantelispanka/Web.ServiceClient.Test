/*
 * Copyright(c) 2016 Modus SA  All Rights Reserved.
 * This software is the proprietary information of Modus SA. 
 */
package gr.modus.papyros.web.client.serialize;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 *
 * @author Charalampos Chomenidis
 * @author Pantelis Karatzas
 */
public abstract class TypeReference<T> implements Comparable<TypeReference<T>> {

    protected final Type _type;

    protected TypeReference() {
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof Class<?>) { // sanity check, should never happen
            throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
        }
        _type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
    }

    public Type getType() {
        return _type;
    }
    
    @Override
    public int compareTo(TypeReference<T> o) {
        return 0;
    }
}
