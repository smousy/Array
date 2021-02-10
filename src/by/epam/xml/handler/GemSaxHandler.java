package by.epam.xml.handler;

import by.epam.xml.entity.Gem;
import by.epam.xml.entity.ParameterGem;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;

import java.time.LocalDate;

import org.xml.sax.helpers.DefaultHandler;

import java.time.format.DateTimeFormatter;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class GemSaxHandler extends DefaultHandler {
    private Set<Gem> gems;
    private Gem current;
    private ParameterGem currentParameter;
    private GemXmlTag currentXmlTag;
    private EnumSet<GemXmlTag> withText;
    public static final Logger logger = LogManager.getLogger();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public GemSaxHandler() {
        gems = new HashSet<>();
        withText = EnumSet.range(GemXmlTag.GEMS, GemXmlTag.EDGES);
    }

    public Set<Gem> getGems() {
        return gems;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        logger.log(Level.INFO, "start element: " + qName);
        if (GemXmlTag.GEM.getValue().equals(qName)) {
            current = new Gem();
            logger.log(Level.INFO, "new gem created");
            for (int i = 0; i < attributes.getLength(); i++) {
                switch (attributes.getQName(i)) {
                    case "preciousness":
                        current.setPreciousness(attributes.getValue(i));
                        logger.log(Level.INFO, "set group: " + attributes.getValue(i));
                        break;
                    case "id":
                        current.setId(attributes.getValue(i));
                        logger.log(Level.INFO, "set id: " + attributes.getValue(i));
                        break;
                }
            }
        }
        /*if(GemXmlTag.PARAMETERS.getValue().equals(qName)) {
            currentParameter = new ParameterGem();
        }if(GemXmlTag.COLOR.getValue().equals(qName)){
            for (int i = 0; i <attributes.getLength() ; i++) {
                currentParameter.getColor().setFrequencyOfMedication(attributes.getValue(0));
                logger.log(Level.INFO, current.getName()+": set frequency of medication : " + attributes.getValue(0));
            }
        }
        else {
            GemXmlTag temp = GemXmlTag.valueOf(qName.toUpperCase().replaceAll("-","_"));
            if(withText.contains(temp)){
                currentXmlTag = temp;
            }
        }*/
    }

    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).strip();
        logger.log(Level.INFO, "read data: " + data);
        if (currentXmlTag != null) {
            switch (currentXmlTag) {
                case NAME:
                    current.setName(data);
                    logger.log(Level.INFO, current.getName() + ": set name: " + data);
                    break;
                case ORIGIN:
                    current.setOrigin(data);
                    logger.log(Level.INFO, current.getName() + ": set origin: " + data);
                    break;
                case VALUE:
                    current.setValue(data);
                    logger.log(Level.INFO, current.getName() + ": set value: " + data);
                    break;
                case COLOR:
                    currentParameter.setColor(data);
                    logger.log(Level.INFO, current.getName() + ": set color: " + data);
                    break;
                case TRANSPARENCY:
                    currentParameter.setTransparency(data);
                    logger.log(Level.INFO, current.getName() + ": set transparency: " + data);
                    break;
                case EDGES:
                    currentParameter.setEdges(data);
                    logger.log(Level.INFO, current.getName() + ": set expiry date: " + data);
                    break;
                case PARAMETERS:
                    current.setParameters(currentParameter);
                    logger.log(Level.INFO, current.getName() + ": added parameter: " + data);
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
    }

    public void endElement(String uri, String localName, String qName) {
        logger.log(Level.INFO, current.getName() + ": end element: " + qName);
        if (GemXmlTag.GEM.getValue().equals(qName)) {
            gems.add(current);
        }
        if (GemXmlTag.PARAMETERS.getValue().equals(qName)) {
            current.setParameters(currentParameter);
        }
    }
}
