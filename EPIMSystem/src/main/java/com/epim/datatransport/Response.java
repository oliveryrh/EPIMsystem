package com.epim.datatransport;

import java.io.Serializable;

public class Response<T> implements Serializable {
    private String message;

    private T object;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
