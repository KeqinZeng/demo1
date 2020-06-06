package com.example.exception;

import com.example.enums.UserEnums;

public class UserException extends RuntimeException{
    private int code;
    private String message;

    public UserException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public UserException(UserEnums userEnums) {
        this.code = userEnums.getCode();
        this.message = userEnums.getMessage();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }




}
