package com.mracus.RESTWeatherApp.util;

public class SensorErrorResponse {
    private String message;
    private Long time;

    public SensorErrorResponse(String message, Long time) {
        this.message = message;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
