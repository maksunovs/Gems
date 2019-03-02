package com.epam.gems.parser;

import com.epam.gems.entity.Gem;

import java.util.List;

public interface Parser {
    List<Gem> parse(String path);
}
