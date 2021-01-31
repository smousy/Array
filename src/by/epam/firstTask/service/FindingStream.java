package by.epam.firstTask.service;

import by.epam.firstTask.entity.ArrayEntity;
import by.epam.firstTask.exeption.InvalidCharacterExeption;
import by.epam.firstTask.validation.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;

public class FindingStream {
    static Logger logger = LogManager.getLogger();

    public int findMinElement(ArrayEntity array) throws InvalidCharacterExeption {
        Validator validator = new Validator();
        if (validator.isEmpty(array)) {
            logger.error("Array can't be empty");
            throw new InvalidCharacterExeption("Array can't be empty");
        }
        logger.info("Min element function");
        int minElement = array.getElement(0);
        int[] initialArray = array.getArray();
        IntStream intStream = IntStream.of(initialArray);
        return intStream.reduce(minElement,
                (x, y) -> {
                    if (y < x) {
                        return y;
                    } else
                        return x;
                });

    }

    public int findMaxElement(ArrayEntity array) throws InvalidCharacterExeption {
        Validator validator = new Validator();
        if (validator.isEmpty(array)) {
            logger.error("Array cant be empty");
            throw new InvalidCharacterExeption("Array cant be empty");
        }
        logger.info("Max element function");
        int maxElement = array.getElement(0);
        int[] initialArray = array.getArray();
        IntStream intStream = IntStream.of(initialArray);
        return intStream.reduce(maxElement,
                (x, y) -> {
                    if (y > x) {
                        return y;
                    } else
                        return x;
                });
    }

    public int findSum(ArrayEntity inputArray) throws InvalidCharacterExeption {
        Validator validator = new Validator();
        if (validator.isEmpty(inputArray)) {
            logger.error("Array cant be empty");
            throw new InvalidCharacterExeption("Array cant be empty");
        }
        int[] array = inputArray.getArray();

        logger.info("Sum of array element");
        return IntStream.of(array)
                .reduce((x, y) -> x + y).getAsInt();
    }

    public int findNumberOfPositiveElements(ArrayEntity inputArray) throws InvalidCharacterExeption {
        Validator validator = new Validator();
        if (validator.isEmpty(inputArray)) {
            logger.error("Array cant be empty");
            throw new InvalidCharacterExeption("Array cant be empty");
        }
        logger.info("Number of positive elements function");
        int[] initialArray = inputArray.getArray();
        return (int) IntStream.of(initialArray).filter(x->x>=0).count();
    }

    public int findNumberOfNegativeElements(ArrayEntity inputArray) throws InvalidCharacterExeption {
        Validator validator = new Validator();
        if (validator.isEmpty(inputArray)) {
            logger.error("Array cant be empty");
            throw new InvalidCharacterExeption("Array cant be empty");
        }
        logger.info("Number of negative elements function");
        int[] initialArray = inputArray.getArray();
        return (int) IntStream.of(initialArray).filter(x->x<0).count();
    }
}
