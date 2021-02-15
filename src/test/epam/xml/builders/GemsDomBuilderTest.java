package test.epam.xml.builders;

import by.epam.xml.builders.GemsDomBuilder;
import by.epam.xml.entity.Gem;
import by.epam.xml.entity.ParameterGem;
import by.epam.xml.exeption.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class GemsDomBuilderTest extends Assert {
    private GemsDomBuilder gemsDomBuilder;
    private String filename;
    Set<Gem> actualResult;
    Set<Gem> expectedResult;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @BeforeTest
    public void setUp() {
        filename ="src/by/epam/xml/data/gem.xml";
        expectedResult = new HashSet<>();
        gemsDomBuilder = new GemsDomBuilder();
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
        gemsDomBuilder = null;
        actualResult = null;
    }
    @Test
    public void testGetMedicines() throws ParseException {
        gemsDomBuilder.buildSetGems(filename);
        actualResult = gemsDomBuilder.getGems();
        assertEquals(actualResult.toString(), expectedResult.toString());
    }
}