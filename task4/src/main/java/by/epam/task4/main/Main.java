package by.epam.task4.main;

import by.epam.task4.action.TextAction;
import by.epam.task4.comparator.ParagraphComporator;
import by.epam.task4.entity.ComponentText;
import by.epam.task4.entity.CompositeText;
import by.epam.task4.exeption.TextException;
import by.epam.task4.parser.DataParser;
import by.epam.task4.parser.impl.TextParserImpl;
import by.epam.task4.reader.CommonReader;
import by.epam.task4.reader.impl.TextReaderImpl;

public class Main {
    public static void main(String[] args) throws TextException {
        CommonReader reader = new TextReaderImpl();
        String text = reader.readAll("resources/data/text.txt");

        DataParser parser = new TextParserImpl();
        ComponentText textComponent = parser.parseText(text);

        ((CompositeText) textComponent).sortComponents(new ParagraphComporator());
        TextAction action = new TextAction();
        action.findSentenceWithLongestWord(textComponent);
        action.findIdenticalWordsAndNumber(textComponent);
        action.removeSentencesWithFewerWords(textComponent, 19);
    }
}