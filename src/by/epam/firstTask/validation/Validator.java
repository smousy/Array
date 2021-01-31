package by.epam.firstTask.validation;

import by.epam.firstTask.entity.ArrayEntity;

public class Validator {

    private static String validString = "[0-9\\s\\-]*";

    public boolean checkString(String string) {
        boolean checkIncorrectSymbols = !string.matches(validString);
        return !checkIncorrectSymbols;
    }

    public boolean isEmpty(ArrayEntity array) {
        return array.sizeArray() <= 0;
    }
}
