package by.epam.task4.parser.impl;

import by.epam.task4.entity.ComponentText;
import by.epam.task4.entity.CompositeText;
import by.epam.task4.entity.TypeComponent;
import by.epam.task4.exeption.TextException;
import by.epam.task4.parser.DataParser;

public class SentenceParcerImpl implements DataParser {
    public static final String LEXEME_SPLIT = "\s";
    private DataParser parser = new LexemeParserImpl();

    //@Override
    public ComponentText parseText(String sentence) throws TextException {
        if (sentence == null || sentence.isEmpty()) {
            throw new TextException("sentence is null or empty");
        }
        CompositeText sentenceComponent = new CompositeText(TypeComponent.SENTENCE);
        String[] lexemeData = sentence.split(LEXEME_SPLIT);
        for (String lexeme : lexemeData) {
            ComponentText lexemeComponent = parser.parseText(lexeme);
            sentenceComponent.addComponent(lexemeComponent);
        }
        return sentenceComponent;
    }
}
