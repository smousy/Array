package by.epam.firstTask.service;

import by.epam.firstTask.entity.ArrayEntity;
import by.epam.firstTask.exeption.InvalidCharacterExeption;
import by.epam.firstTask.validation.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Finding {
    static Logger logger = LogManager.getLogger();

    public int findMinElement(ArrayEntity array) throws InvalidCharacterExeption {
        Validator validator = new Validator();
        if (validator.isEmpty(array)) {
            logger.error("Array cant be empty");
            throw new InvalidCharacterExeption("Array cant be empty");
        }
        int minElement = array.getElement(0);
        for (int i = 0; i < array.sizeArray(); i++) {
            if (array.getElement(i) < minElement) {
                minElement = array.getElement(i);
            }
        }
        logger.info("Min element is " + minElement);
        return minElement;
    }

    public int findMaxElement(ArrayEntity array) throws InvalidCharacterExeption {
        Validator validator = new Validator();
        if (validator.isEmpty(array)) {
            logger.error("Array cant be empty");
            throw new InvalidCharacterExeption("Array cant be empty");
        }
        int maxElement = array.getElement(0);
        for (int i = 0; i < array.sizeArray(); i++) {
            if (array.getElement(i) > maxElement) {
                maxElement = array.getElement(i);
            }
        }
        logger.info("Max element is " + maxElement);
        return maxElement;
    }

    public double findAverage(ArrayEntity inputArray) throws InvalidCharacterExeption {
        Validator validator = new Validator();
        if (validator.isEmpty(inputArray)) {
            logger.error("Array cant be empty");
            throw new InvalidCharacterExeption("Array cant be empty");
        }
        int sum = findSum(inputArray);
        double size = (double) inputArray.sizeArray();
        logger.info("Average value is " + sum / size);
        return sum / size;

    }

    public int findSum(ArrayEntity inputArray) throws InvalidCharacterExeption {
        Validator validator = new Validator();
        if (validator.isEmpty(inputArray)) {
            logger.error("Array cant be empty");
            throw new InvalidCharacterExeption("Array cant be empty");
        }
        int sum = 0;
        for (int i = 0; i < inputArray.sizeArray(); i++) {
            int element = inputArray.getElement(i);
            sum += element;
        }
        logger.info("Sum of array element is " + sum);
        return sum;
    }

    public int findNumberOfPositiveElements(ArrayEntity inputArray) throws InvalidCharacterExeption {
        Validator validator = new Validator();
        if (validator.isEmpty(inputArray)) {
            logger.error("Array cant be empty");
            throw new InvalidCharacterExeption("Array cant be empty");
        }
        int number = 0;
        for (int i = 0; i < inputArray.sizeArray(); i++) {
            int element = inputArray.getElement(i);
            if (element > 0) {
                number++;
            }
        }
        logger.info("Number of positive elements is " + number);
        return number;
    }

    public int findNumberOfNegativeElements(ArrayEntity inputArray) throws InvalidCharacterExeption {
        Validator validator = new Validator();
        if (validator.isEmpty(inputArray)) {
            logger.error("Array cant be empty");
            throw new InvalidCharacterExeption("Array cant be empty");
        }
        int number = 0;
        for (int i = 0; i < inputArray.sizeArray(); i++) {
            int element = inputArray.getElement(i);
            if (element < 0) {
                number++;
            }
        }
        logger.info("Number of negative elements is " + number);
        return number;
    }
}
