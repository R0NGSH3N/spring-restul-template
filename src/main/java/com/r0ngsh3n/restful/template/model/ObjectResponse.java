package com.r0ngsh3n.restful.template.model;

public class ObjectResponse<T> {
    // Status Code
    private int code;
    //message
    private String msg;
    //return data
    private T data;

    public ObjectResponse(T data) {
        this(1000, "success", data);
    }

    public ObjectResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
