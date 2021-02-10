package test.epam.xml.builders;

import by.epam.xml.builders.AbstractGemsBuilder;
import by.epam.xml.entity.Gem;
import by.epam.xml.exeption.ParseException;
import by.epam.xml.handler.GemSaxHandler;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class GemsSaxBuilderTest extends AbstractGemsBuilder {
    public static final Logger logger = LogManager.getLogger();
    private Set<Gem> gems;
    private GemSaxHandler handler = new GemSaxHandler();
    private XMLReader reader;

    public GemsSaxBuilderTest() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            logger.log(Level.ERROR, "caught exception: " + e);
        }
        reader.setContentHandler(handler);
    }

    public GemsSaxBuilderTest(Set<Gem> gems) {
        super(gems);
    }

    public Set<Gem> getGems() {
        logger.log(Level.INFO, "return list gems");
        return gems;
    }

    @Override
    public void buildSetGems(String filename) throws ParseException {
        try {
            reader.parse(filename);
        } catch (IOException | SAXException e) {
            throw new ParseException("Parser configuration exception or SAXExcetion ", e);
        }
        gems = handler.getGems();
        logger.log(Level.INFO, "built set medicines");
    }
}
