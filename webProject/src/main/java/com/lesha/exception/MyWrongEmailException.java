package com.lesha.exception;

public class MyWrongEmailException extends Exception{
    public String getMessage(){
        return "Error: you write fake or existed email !!! ";
    }
}
