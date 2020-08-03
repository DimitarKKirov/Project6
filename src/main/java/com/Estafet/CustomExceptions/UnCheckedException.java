package com.Estafet.CustomExceptions;

public class UnCheckedException extends Exception {


public UnCheckedException() {
}

    public UnCheckedException(String message){
    super(message);
    }
public UnCheckedException(Throwable cause){
    super(String.valueOf(cause));
}

}
