package com.epam.firstTask.exeption;

import com.epam.firstTask.reader.Converter;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class InvalidCharacterExeption extends Exception {
    public InvalidCharacterExeption() {
    }

    public InvalidCharacterExeption(String message) {
        super(message);
    }

    public InvalidCharacterExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCharacterExeption(Throwable cause) {
        super(cause);
    }

}
