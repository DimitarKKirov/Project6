package com.estafet.learning.CustomExceptions;

public class CustomClassNotFound extends ClassNotFoundException {

    public CustomClassNotFound(String message, Throwable cause) {
        super(message, cause);
    }
    public CustomClassNotFound(String message){
        super(message);
    }
    public CustomClassNotFound(Throwable cause){
        super(String.valueOf(cause));
    }
}
