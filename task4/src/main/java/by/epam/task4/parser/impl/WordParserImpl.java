package by.epam.task4.parser.impl;

import by.epam.task4.entity.ComponentText;
import by.epam.task4.entity.CompositeText;
import by.epam.task4.entity.Symbol;
import by.epam.task4.entity.TypeComponent;
import by.epam.task4.parser.DataParser;

public class WordParserImpl implements DataParser {
    public ComponentText parseText(String word) {
        CompositeText wordComponent = new CompositeText(TypeComponent.WORD);
        char[] symbols = word.toCharArray();
        Symbol symbolComponent;
        for (char symbol : symbols) {
            symbolComponent = new Symbol(TypeComponent.LETTER, symbol);
            wordComponent.addComponent(symbolComponent);
        }
        return wordComponent;
    }
}
