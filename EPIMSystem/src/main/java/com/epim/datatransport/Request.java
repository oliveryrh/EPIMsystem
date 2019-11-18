package com.epim.datatransport;

import java.io.Serializable;

public class Request<T> implements Serializable {
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
