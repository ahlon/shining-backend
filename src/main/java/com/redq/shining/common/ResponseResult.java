package com.redq.shining.common;

import lombok.Data;

import java.util.Date;

/**
 * @author ahlon
 */
@Data
public class ResponseResult<T> {

    private boolean success;
    private String message;
    private Date timestamp;
    private T data;

    public ResponseResult(boolean success, T data) {
        this.success = success;
        this.timestamp = new Date();
        this.data = data;
    }

    public ResponseResult(boolean success, String message, T data) {
        this.success = success;
        this.timestamp = new Date();
        this.message = message;
        this.data = data;
    }

    public static ResponseResult success(Object data) {
        return new ResponseResult(true, "", data);
    }

    public static ResponseResult success(Object data, String message) {
        return new ResponseResult(true, message, data);
    }

    public static ResponseResult fail(Object data, String message) {
        return new ResponseResult(false, message, data);
    }


}
