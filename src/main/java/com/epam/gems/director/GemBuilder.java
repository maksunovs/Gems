package com.epam.gems.director;

import com.epam.gems.entity.Gem;
import com.epam.gems.exceptions.InvalidXMLDocumentException;
import com.epam.gems.exceptions.ParserException;
import com.epam.gems.parser.Parser;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class GemBuilder {
    private Parser parser;
    private SAXValidator validator;
    private static final Logger LOGGER = Logger.getLogger(GemBuilder.class);

    public GemBuilder(Parser parser, SAXValidator validator) {
        this.validator = validator;
        this.parser = parser;
    }

    public List<Gem> buildGemsFrom(String xmlPath) throws InvalidXMLDocumentException {
        List<Gem> result = new ArrayList<>();

        if (validator.validate(xmlPath)) {
            try {
                result = parser.parse(xmlPath);
            } catch (ParserException err) {
                LOGGER.error(err.getMessage());
            }
        } else {
            throw new InvalidXMLDocumentException("XML document is invalid");
        }
        return result;
    }
    public void setParser(Parser parser){
        this.parser=parser;
    }
}
