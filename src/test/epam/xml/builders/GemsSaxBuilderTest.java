package test.epam.xml.builders;

import by.epam.xml.builders.GemsSaxBuilder;
import by.epam.xml.entity.Gem;
import by.epam.xml.entity.ParameterGem;
import by.epam.xml.exeption.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class GemsSaxBuilderTest {
    private GemsSaxBuilder gemSAXBuilder;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    Set<Gem> actualResult;
    Set<Gem> expectedResult;

    @BeforeMethod
    public void setUp() {
        expectedResult = new HashSet<>();
        gemSAXBuilder = new GemsSaxBuilder();
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
    @AfterMethod
    public void tearDown() {
        gemSAXBuilder = null;
        actualResult = null;
    }
    @Test
    public void testGetMedicines() throws ParseException {
        gemSAXBuilder.buildSetGems("src/by/epam/xml/data/gem.xml");
        actualResult = gemSAXBuilder.getGems();
        assertEquals(actualResult.toString(), expectedResult.toString());
    }
}

