package com.Estafet.CustomExceptions;

import java.io.*;

public class CustomExceptionIO extends IOException {

    public  CustomExceptionIO(String message,Throwable cause){
        super(message, cause);
    }
    public CustomExceptionIO(String message){
        super(message);
    }
}
