package com.Estafet.CustomExceptions;

public class CustomException extends Exception {
    public CustomException(){};
    public CustomException(String message,Throwable cause){
        super(message, cause);
    }

    public CustomException(String getter_does_not_work) {
        System.out.println("Getter does not work");
    }
}
