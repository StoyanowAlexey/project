package com.lesha.exception;

public class MyWrongIndexException extends Exception{
     public String getMessage(){
         return  "Found no users with this id !!!";
     }
}
