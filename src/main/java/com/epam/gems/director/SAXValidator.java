package com.epam.gems.director;


import com.epam.gems.exceptions.ValidationErrorException;
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
    private String xsdPath;
    private static final Logger LOGGER = Logger.getLogger(SAXValidator.class);

    public SAXValidator(String xsdPath) {
        this.xsdPath = xsdPath;
    }

    public boolean validate(String xmlPath) throws ValidationErrorException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        boolean flag = false;
        try {
            Schema schema = factory.newSchema(new File(xsdPath));
            javax.xml.validation.Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlPath);
            validator.validate(source);
            LOGGER.info(xmlPath + " is valid");
            flag = true;
        } catch (SAXException err) {
            throw  new ValidationErrorException("validate " + xmlPath + " is not valid because " + err.getMessage());
        } catch (IOException err) {
            throw  new ValidationErrorException(xmlPath + " is not valid because " + err.getMessage());
        }

        return flag;
    }
    public void setSchema(String xsdPath){
        this.xsdPath=xsdPath;
    }

}
