package com.epam.gems.parser;

import com.epam.gems.entity.Gem;
import com.epam.gems.exceptions.ParserException;

import java.util.List;

public interface Parser {
    List<Gem> parse(String path) throws ParserException;
}
