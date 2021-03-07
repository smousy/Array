package by.epam.task4.parser;

import by.epam.task4.entity.ComponentText;
import by.epam.task4.exeption.TextException;

public interface DataParser {
    ComponentText parseText(String text) throws TextException;
}
