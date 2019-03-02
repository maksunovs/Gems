package com.epam.gems.parser.impl;

import com.epam.gems.entity.Gem;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class JAXBParserTest {
    private static final JAXBParser PARSER = new JAXBParser();
    private static final String XML_PATH = "src/test/java/gems.xml";
    @Test
    public void parseTest() {
        List<Gem> list = PARSER.parse(XML_PATH);
        System.out.println(list);
    }
}