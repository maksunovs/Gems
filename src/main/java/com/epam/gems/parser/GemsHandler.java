package com.epam.gems.parser;

import com.epam.gems.entity.Gem;
import com.epam.gems.entity.PreciousStone;
import com.epam.gems.entity.SemipreciousStone;
import com.epam.gems.entity.VisualParameters;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

public class GemsHandler extends DefaultHandler {
    private static final Logger LOGGER = Logger.getLogger(GemsHandler.class);
    private List<Gem> gems;
    private Gem current = null;
    private GemEnum currentEnum = null;
    private EnumSet<GemEnum> withText;

    public GemsHandler() {
        gems = new ArrayList<>();
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

    public List<Gem> getGems() {
        return gems;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (localName.equals("gems")) return;
        if (localName.equals("precious")) {
            current = new PreciousStone();
            current.setName(attributes.getValue(0));
        } else if (localName.equals("semiprecious")) {
            current = new SemipreciousStone();
            current.setName(attributes.getValue(0));
        } else {
            GemEnum temp = null;
            EnumSet<GemEnum> all = EnumSet.allOf(GemEnum.class);
            for (GemEnum element : all) {
                if (element.getValue().equals(localName)) {
                    temp = element;
                    break;
                }
            }
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

    @Override
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
