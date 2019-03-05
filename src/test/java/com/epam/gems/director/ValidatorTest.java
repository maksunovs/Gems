package com.epam.gems.director;

import com.epam.gems.exceptions.ValidationErrorException;
import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {
    private static final String XML_PATH = "src/test/java/gems.xml";
    private static final String XSD_PATH = "src/main/resources/gemsXSD.xsd";
    private static final SAXValidator VALIDATOR = new SAXValidator(XSD_PATH);

    @Test
    public void shouldBeValidWhenCorrectXMLSupplied() throws ValidationErrorException {
        Assert.assertTrue(VALIDATOR.validate(XML_PATH));
    }
}