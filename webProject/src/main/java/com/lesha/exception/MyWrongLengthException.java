package com.lesha.exception;

public class MyWrongLengthException extends Throwable {
    public String getMessage(){
        return "Error: false length ";
    }
}
