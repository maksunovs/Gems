package com.epam.gems.parser.impl;

import com.epam.gems.entity.Gem;
import com.epam.gems.entity.Gems;
import com.epam.gems.parser.Parser;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JAXBParser implements Parser {
    private static final Logger LOGGER = Logger.getLogger(JAXBParser.class);
    @Override
    public List<Gem> parse(String path) {
        Gems gems = new Gems();
        try {
            JAXBContext jc = JAXBContext.newInstance(Gems.class);
            Unmarshaller u = jc.createUnmarshaller();
            gems=(Gems)u.unmarshal(new File(path));
        }catch(JAXBException err){
            LOGGER.error(err);
        }
        return gems.getList();
    }
}
