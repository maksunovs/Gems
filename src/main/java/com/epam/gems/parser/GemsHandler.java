package com.epam.gems.parser;

import com.epam.gems.entity.Gem;
import com.epam.gems.entity.PreciousStone;
import com.epam.gems.entity.SemipreciousStone;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class GemsHandler extends DefaultHandler {
    private static final Logger LOGGER = Logger.getLogger(GemsHandler.class);
    private Set<Gem> gems;
    private Gem current = null;
    private GemEnum currentEnum = null;
    private EnumSet<GemEnum> withText;

    public GemsHandler() {
        gems = new HashSet<>();
        withText = EnumSet.of(GemEnum.PRECIOUSNESS,
                GemEnum.ORIGIN,
                GemEnum.COLOR,
                GemEnum.TRANSPARENCY,
                GemEnum.LUSTRE,
                GemEnum.VALUE,
                GemEnum.HARDNESS,
                GemEnum.PRICE,
                GemEnum.RARITY);
    }

    public Set<Gem> getGems() {
        return gems;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (localName.equals("precious")) {
            current = new PreciousStone();
            current.setName(attributes.getValue(0));
        } else if (localName.equals("semiprecious")) {
            current = new SemipreciousStone();
            current.setName(attributes.getValue(0));
        } else {
            GemEnum temp = GemEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) {
        if (localName.equals("precious") || localName.equals("semiprecious")) {
            gems.add(current);
        }
    }


    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case PRECIOUSNESS:
                    current.setPreciousness(data);
                    break;
                case ORIGIN:
                    current.setOrigin(data);
                    break;
                case COLOR:
                    current.getVisualParameters().setColor(data);
                    break;
                case TRANSPARENCY:
                    current.getVisualParameters().setTransparency(Integer.parseInt(data));
                    break;
                case LUSTRE:
                    current.getVisualParameters().setLustre(data);
                    break;
                case VALUE:
                    current.setValue(Double.parseDouble(data));
                    break;
                case HARDNESS:
                    current.setHardness(Double.parseDouble(data));
                    break;
                case PRICE:
                    ((SemipreciousStone) current).setPrice(Double.parseDouble(data));
                    break;
                case RARITY:
                    ((PreciousStone) current).setRarity(data);
                    break;
                default:
                    LOGGER.info("Enum constant " + currentEnum.name() + " is not present");
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), "Enum constant" + currentEnum.name() + "is not present");
            }
        }
        currentEnum = null;
    }
}
