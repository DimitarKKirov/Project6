package com.estafet.learning.CustomExceptions;


import java.io.FileNotFoundException;

public class CustomFileNotFound extends FileNotFoundException {
public CustomFileNotFound(String message){
    super(message);
}
}
