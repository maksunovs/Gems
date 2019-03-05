package com.epam.gems.parser.impl;

import com.epam.gems.entity.Gem;
import com.epam.gems.entity.Gems;
import com.epam.gems.exceptions.JAXBParserException;
import com.epam.gems.parser.Parser;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import java.util.List;

public class GemJAXBParser implements Parser {

    @Override
    public List<Gem> parse(String path) throws JAXBParserException {
        Gems gems;
        try {
            JAXBContext jc = JAXBContext.newInstance(Gems.class);
            Unmarshaller u = jc.createUnmarshaller();
            gems = (Gems) u.unmarshal(new File(path));
        } catch (JAXBException err) {
            throw new JAXBParserException(err.getMessage());
        }
        return gems.getList();
    }
}
