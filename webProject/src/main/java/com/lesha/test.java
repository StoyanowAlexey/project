package com.lesha;

public class test {
    public static void main(String [] args){
        String URL = System.getenv("DATABASE_URL");
        String USER = System.getenv("USERNAME");
        String PASSWORD = System.getenv("PASSWORD");
        System.out.println("Url = " + URL + ", username = " + USER + ", password = " + PASSWORD);
    }
}
