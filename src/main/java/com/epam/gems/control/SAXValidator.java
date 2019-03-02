package com.epam.gems.control;



import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;


public class SAXValidator {
    private static final   String  XSD_PATH = "src/main/resources/gemsXSD.xsd";
    private static final Logger LOGGER = Logger.getLogger(SAXValidator.class);

    public boolean validate(String xmlPath) {
        getClass().getClassLoader().getResourceAsStream(XSD_PATH);
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        boolean flag=false;
        try {
            Schema schema = factory.newSchema(new File(XSD_PATH));
            javax.xml.validation.Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlPath);
            validator.validate(source);
            LOGGER.info(xmlPath + " is valid");
            flag=true;
        } catch (SAXException err) {
            LOGGER.error("validate " + xmlPath + " is not valid because " + err.getMessage());
        } catch (IOException err) {
            LOGGER.error(xmlPath + " is not valid because " + err.getMessage());
        }
        return flag;
    }

}
