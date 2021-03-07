package by.epam.task4.parser.impl;

import by.epam.task4.entity.ComponentText;
import by.epam.task4.entity.CompositeText;
import by.epam.task4.entity.TypeComponent;
import by.epam.task4.exeption.TextException;
import by.epam.task4.parser.DataParser;
import org.apache.logging.log4j.Level;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TextParserImpl implements DataParser{
    public static Logger logger = LogManager.getLogger();
    public static final String PARAGRAPH_SPLIT = "\s{4}";
    private DataParser parser = new ParagraphParserImpl();

    //@Override
    public ComponentText parseText(String text) throws TextException {
        if (text == null || text.isEmpty()) {
            throw new TextException("text is null or empty");
        }
        CompositeText textComponent = new CompositeText(TypeComponent.TEXT);
        String[] paragraphData = text.split(PARAGRAPH_SPLIT);
        for (String paragraph : paragraphData) {
            if (!paragraph.isEmpty()) {
                ComponentText paragraphComponent = parser.parseText(paragraph);
                textComponent.addComponent(paragraphComponent);
            }
        }
        logger.log(Level.INFO, "after parsing the component text is created: " + textComponent.toString());
        return textComponent;
    }
}
