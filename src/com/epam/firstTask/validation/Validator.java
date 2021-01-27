package com.epam.firstTask.validation;

public class Validator {

    private static String validString = "[0-9\\s\\-]*";

   public  boolean checkString (String string){
        boolean checkIncorrectSymbols = !string.matches(validString);
        return !checkIncorrectSymbols;
    }
}
