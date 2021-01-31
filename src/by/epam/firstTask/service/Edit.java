package by.epam.firstTask.service;

import by.epam.firstTask.exeption.ArrayActionExeption;
import by.epam.firstTask.entity.ArrayEntity;
import by.epam.firstTask.exeption.InvalidCharacterExeption;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Edit {
    static Logger logger = LogManager.getLogger();

    public ArrayEntity changePrimeElementToNull(ArrayEntity inputArray) throws ArrayActionExeption, InvalidCharacterExeption {
        if (inputArray != null) {
            for (int i = 0; i < inputArray.sizeArray(); i++) {
                int element = inputArray.getElement(i);
                if (primeCheck(element)) {
                    inputArray.changeElement(i, 0);
                }
            }
            logger.info("change prime element to null");
            return inputArray;
        } else {
            logger.error("null array");
            throw new ArrayActionExeption("Null array");
        }
    }

    private boolean primeCheck(int number) {
        int temp;
        if (number <= 0) {
            return false;
        } else {
            for (int i = 2; i <= number / 2; i++) {
                temp = number % i;
                if (temp == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
