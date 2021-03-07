package by.epam.task4.reader;

import by.epam.task4.exeption.TextException;

public interface CommonReader {
    String readAll(String path) throws TextException;
}
