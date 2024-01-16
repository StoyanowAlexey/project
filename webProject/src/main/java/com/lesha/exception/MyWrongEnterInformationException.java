package com.lesha.exception;

public class MyWrongEnterInformationException extends Exception {

    public String getMessage(){
        return "Error: you write wrong information";
    }
}
