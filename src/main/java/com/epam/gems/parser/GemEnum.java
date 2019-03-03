package com.epam.gems.parser;

public enum GemEnum {
    GEMS("gems"),
    PRECIOUS("precious"),
    SEMIPRECIOUS("semiprecious"),
    PRECIOUSNESS("preciousness"),
    ORIGIN("origin"),
    VISUAL_PARAMETERS("visual-parameters"),
    COLOR("color"),
    TRANSPARENCY("transparency"),
    LUSTRE("lustre"),
    VALUE("value"),
    HARDNESS("hardness"),
    PRICE("price"),
    RARITY("rarity");
    private final String value;

    GemEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
