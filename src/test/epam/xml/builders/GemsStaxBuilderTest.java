package test.epam.xml.builders;

import by.epam.xml.builders.AbstractGemsBuilder;
import by.epam.xml.entity.Gem;
import by.epam.xml.entity.ParameterGem;
import by.epam.xml.exeption.ParseException;
import by.epam.xml.handler.GemXmlTag;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class GemsStaxBuilderTest extends AbstractGemsBuilder {


    public static final Logger logger = LogManager.getLogger();
    public static final String HYPHEN = "-";
    public static final String UNDERSCORE = "_";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private Set<Gem> gemSet;
    private XMLInputFactory inputFactory;

    public GemsStaxBuilderTest() {
        inputFactory = XMLInputFactory.newInstance();
        gemSet = new HashSet<Gem>();
        logger.log(Level.INFO, "gems empty set created");
    }

    public GemsStaxBuilderTest(Set<Gem> gemSet) {
        super(gemSet);
    }

    public Set<Gem> getGemSet() {
        logger.log(Level.INFO, "Gems set returned");
        return gemSet;
    }

    @Override
    public void buildSetGems(String filename) throws ParseException {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream((new File(filename)))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    logger.log(Level.INFO, "founded start tag: " + name);
                    if (name.equals(GemXmlTag.GEM.getValue())) {
                        Gem gem = buildGem(reader);
                        gemSet.add(gem);
                        logger.log(Level.INFO, "new gem added to gems set");
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            throw new ParseException("Parser configuration exception or SAXException ", e);

        } catch (IOException e) {
            throw new ParseException("IOException generated ", e);
        }
    }

    private Gem buildGem(XMLStreamReader reader) throws XMLStreamException {
        Gem gem = new Gem();
        gem.setId(reader.getAttributeValue(null, GemXmlTag.ID.getValue()));
        gem.setPreciousness(reader.getAttributeValue(null, GemXmlTag.PRECIOUSNESS.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (GemXmlTag.valueOf(name.toUpperCase().replaceAll(HYPHEN, UNDERSCORE))) {
                        case NAME:
                            gem.setName(getXMLText(reader));
                            logger.log(Level.INFO, "name " + gem.getName() + " set");
                            break;
                        case ORIGIN:
                            gem.setOrigin(getXMLText(reader));
                            logger.log(Level.INFO, "origin " + gem.getOrigin() + " set");
                            break;
                        case VALUE:
                            gem.setValue(getXMLText(reader));
                            logger.log(Level.INFO, "value " + gem.getValue() + " set");
                            break;
                        case PARAMETERS:
                            gem.setParameters(buildParameters(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (GemXmlTag.valueOf(name.toUpperCase().replaceAll(HYPHEN, UNDERSCORE)) == GemXmlTag.GEM) {
                        logger.log(Level.INFO, "new gem returned");
                        return gem;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <gem>");
    }

    private ParameterGem buildParameters(XMLStreamReader reader) throws XMLStreamException {
        ParameterGem parameterGem = new ParameterGem();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (GemXmlTag.valueOf(name.toUpperCase().replaceAll(HYPHEN, UNDERSCORE))) {
                        case COLOR:
                            parameterGem.setColor(getXMLText(reader));
                            logger.log(Level.INFO, "color " + parameterGem.getColor() + " set");
                            break;
                        case TRANSPARENCY:
                            parameterGem.setTransparency(getXMLText(reader));
                            logger.log(Level.INFO, "trencparency " + parameterGem.getTransparency() + " set");
                            break;
                        case EDGES:
                            parameterGem.setEdges(getXMLText(reader));
                            logger.log(Level.INFO, "edges " + parameterGem.getEdges() + " set");
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (GemXmlTag.valueOf(name.toUpperCase().replaceAll(HYPHEN, UNDERSCORE)) == GemXmlTag.PARAMETERS) {
                        return parameterGem;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <version>");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

}
