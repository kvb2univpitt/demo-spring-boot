package com.github.kvb2univpitt.demo.secured.webapp;

/**
 *
 * Dec 27, 2020 12:57:46 AM
 *
 * @author Kevin V. Bui (kvb2univpitt@gmail.com)
 */
public class HttpError {

    private int code;

    private String status;

    private String message;

    public HttpError() {
    }

    public HttpError(int code, String status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
