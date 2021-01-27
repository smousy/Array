package com.epam.firstTask.exeption;

import com.epam.firstTask.reader.Converter;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayActionExeption extends Exception{
   public ArrayActionExeption(){
   }

    public ArrayActionExeption(String message){
       super(message);
    }

    public ArrayActionExeption(String message, Throwable cause){
       super(message,cause);
    }

    public ArrayActionExeption(Throwable cause){
       super(cause);
    }
}
