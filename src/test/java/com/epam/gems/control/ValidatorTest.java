package com.epam.gems.control;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {
    private static final String XML_PATH = "src/test/java/gems.xml";
    private static final String XSD_PATH = "src/main/resources/gemsXSD.xsd";
    private static final SAXValidator VALIDATOR = new SAXValidator(XSD_PATH);

    @Test
    public void shouldBeValidWhenCorrectXMLSupplied() {
        Assert.assertTrue(VALIDATOR.validate(XML_PATH));
    }
}