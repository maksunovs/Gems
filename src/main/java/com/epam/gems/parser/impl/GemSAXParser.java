package com.epam.gems.parser.impl;

import com.epam.gems.entity.Gem;
import com.epam.gems.exceptions.DOMParserException;
import com.epam.gems.exceptions.SAXParserException;
import com.epam.gems.parser.GemsHandler;
import com.epam.gems.parser.Parser;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class GemSAXParser implements Parser {
    private GemsHandler gemsHandler;
    private  XMLReader reader;
    private static final Logger LOGGER = Logger.getLogger(GemSAXParser.class);
    public GemSAXParser() {
        gemsHandler = new GemsHandler();
        try{
            reader= XMLReaderFactory.createXMLReader();
            reader.setContentHandler(gemsHandler);
        }catch(SAXException err){
            LOGGER.error(err);
        }
    }
    public List<Gem> parse(String path) throws SAXParserException {
//        try {
//            SAXParserFactory factory = SAXParserFactory.newInstance();
//            SAXParser saxParser = factory.newSAXParser();
//            saxParser.parse(new File(path),gemsHandler);
//        }catch (SAXException|ParserConfigurationException| IOException err){
//            LOGGER.error(err);
//        }
    try{
        reader.parse(path);
    }catch (IOException err) {
        throw new SAXParserException("File error or I/O error: " + err.getMessage());
    } catch (SAXException err) {
        throw new SAXParserException("Parsing error: " + err.getMessage());
    }
        return gemsHandler.getGems();
    }
}
