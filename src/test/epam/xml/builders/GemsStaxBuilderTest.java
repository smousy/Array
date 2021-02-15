package test.epam.xml.builders;

import by.epam.xml.builders.AbstractGemsBuilder;
import by.epam.xml.builders.GemsDomBuilder;
import by.epam.xml.builders.GemsStaxBuilder;
import by.epam.xml.entity.Gem;
import by.epam.xml.entity.ParameterGem;
import by.epam.xml.exeption.ParseException;
import by.epam.xml.handler.GemXmlTag;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

public class GemsStaxBuilderTest extends Assert {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private GemsStaxBuilder gemsStaxBuilder;
    Set<Gem> actualResult;
    Set<Gem> expectedResult;

    @BeforeTest
    public void setUp() {
        expectedResult = new HashSet<>();
        gemsStaxBuilder = new GemsStaxBuilder();
        Gem gem = new Gem();
        ParameterGem parameterGem = new ParameterGem();
        gem.setPreciousness("precious");
        gem.setId("a1");
        gem.setName("Алмаз");
        gem.setValue("10");
        gem.setOrigin("Минск");
        parameterGem.setColor("green");
        parameterGem.setTransparency("80");
        parameterGem.setEdges("13");
        gem.setParameters(parameterGem);
        expectedResult.add(gem);
    }
    @AfterTest
    public void tearDown() {
        gemsStaxBuilder = null;
        actualResult = null;
    }
    @Test
    public void testGetMedicines() throws ParseException {
        gemsStaxBuilder.buildSetGems("src/by/epam/xml/data/gem.xml");
        actualResult = gemsStaxBuilder.getGems();
        assertEquals(actualResult.toString(), expectedResult.toString());
    }
}

