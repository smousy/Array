package by.epam.xml.builders;

import by.epam.xml.entity.Gem;
import by.epam.xml.entity.ParameterGem;
import by.epam.xml.exeption.ParseException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class GemsDomBuilder extends AbstractGemsBuilder {

    private DocumentBuilder docBuilder;
    public static final Logger logger = LogManager.getLogger();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public GemsDomBuilder() {
        gems = new HashSet<>();
        logger.log(Level.INFO, "new empty gems list created");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.log(Level.ERROR, "caught exception: " + e);
        }
    }

    public GemsDomBuilder(Set<Gem> gems) {
        super(gems);
    }

    @Override
    public void buildSetGems(String filename) throws ParseException {
        Document doc;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            NodeList gemsList = root.getElementsByTagName("gem");
            for (int i = 0; i < gemsList.getLength(); i++) {
                Element gemElement = (Element) gemsList.item(i);
                Gem gem = buildGem(gemElement);
                gems.add(gem);
                logger.log(Level.INFO, "gem added to list");
            }
        } catch (IOException | SAXException e) {
            throw new ParseException("Parser configuration exception or SAXExcetion ", e);
        }
    }

    private Gem buildGem(Element gemElement) {
        Gem gem = new Gem();
        if (null != gemElement) {
            ParameterGem parameters;
            gem.setPreciousness(gemElement.getAttribute("preciousness"));
            logger.log(Level.INFO, "precious " + gemElement.getAttribute("precious") + "set");
            gem.setId(gemElement.getAttribute("id"));
            logger.log(Level.INFO, "id " + gemElement.getAttribute("id") + "set");
            gem.setName(getElementTextContext(gemElement, "name"));
            logger.log(Level.INFO, "name " + getElementTextContext(gemElement, "name") + "set");
            gem.setOrigin(getElementTextContext(gemElement, "origin"));
            logger.log(Level.INFO, "origin " + getElementTextContext(gemElement, "origin") + "set");
            gem.setValue(getElementTextContext(gemElement, "value"));
            logger.log(Level.INFO, "value " + getElementTextContext(gemElement, "value") + "set");

            NodeList nodeList = gemElement.getElementsByTagName("parameters");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element parameterElement = (Element) nodeList.item(i);
                parameters = new ParameterGem();
                parameters.setColor(getElementTextContext(parameterElement, "color"));
                logger.log(Level.INFO, "color " + getElementTextContext(parameterElement, "color") + "set");
                parameters.setTransparency(getElementTextContext(parameterElement, "transparency"));
                parameters.setEdges(getElementTextContext(parameterElement, "edges"));
                gem.setParameters(parameters);
                logger.log(Level.INFO, "new parameters added");
            }

        }
        return gem;
    }

    private String getElementTextContext(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

}
