package com.epam.gems.parser.impl;

import com.epam.gems.entity.Gem;
import com.epam.gems.entity.PreciousStone;
import com.epam.gems.entity.SemipreciousStone;
import com.epam.gems.entity.VisualParameters;
import com.epam.gems.exceptions.JAXBParserException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ParserTest {
    private static final JAXBParser PARSER = new JAXBParser();
    private static final String XML_PATH = "src/test/java/gems.xml";
    private static List<Gem> expected;

    @BeforeClass
    public static void initializeExpectedList() {
        expected = Arrays.asList(new PreciousStone("ruby", "precious", "Australia", new VisualParameters("red", 85, "vitreous"), 8.62, 9, "rare"),
                new PreciousStone("tourmaline", "precious", "China", new VisualParameters("pink", 50, "vitreous"), 10, 7, "rare"),
                new PreciousStone("diamond", "precious", "Africa", new VisualParameters("colorless", 100, "adamantine"), 2, 10, "very rare"),
                new SemipreciousStone("amethyst", "semiprecious", "Brazil", new VisualParameters("violet", 70, "vitreous"), 5.2, 7, 300),
                new SemipreciousStone("garnet", "semiprecious", "Russia", new VisualParameters("red", 75, "vitreous"), 4.2, 8, 600),
                new SemipreciousStone("malachite", "semiprecious", "Kazakhstan", new VisualParameters("green", 0, "silky"), 3.9, 3, 250));
    }

    @Test
    public void JAXBParserShouldCreateListOfGemsFromXML() throws JAXBParserException {
        List<Gem> actual = PARSER.parse(XML_PATH);
        Assert.assertEquals(actual.get(0), expected.get(0));
    }

    @Test
    public void SAXParserShouldCreateListOfGemsFromXML() {

    }

    @Test
    public void DOMParserShouldCreateListOfGemsFromXML() {

    }
}