package com.epam.gems.control;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {
    private static final String XML_PATH = "src/test/java/gems.xml";
    private static final SAXValidator VALIDATOR = new SAXValidator();
    @Test
    public void shouldBeValidWhenCorrectXMLSupplied(){
        Assert.assertTrue(VALIDATOR.validate(XML_PATH));
    }
}