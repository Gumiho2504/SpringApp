package com.gumiho.cruddemo.respone;

public class EmployeeErrorResponse {
    private int status;
    private String message;
    private long timeStemp;



    public EmployeeErrorResponse(){

    }

    public EmployeeErrorResponse(int status, String message, long timeStemp) {
        this.status = status;
        this.message = message;
        this.timeStemp = timeStemp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStemp() {
        return timeStemp;
    }

    public void setTimeStemp(long timeStemp) {
        this.timeStemp = timeStemp;
    }
}
