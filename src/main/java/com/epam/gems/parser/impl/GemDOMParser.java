package com.epam.gems.parser.impl;

import com.epam.gems.entity.Gem;
import com.epam.gems.entity.PreciousStone;
import com.epam.gems.entity.SemipreciousStone;
import com.epam.gems.exceptions.DOMParserException;
import com.epam.gems.exceptions.WrongDataException;
import com.epam.gems.parser.Parser;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GemDOMParser implements Parser {
    private static final Logger LOGGER = Logger.getLogger(GemDOMParser.class);
    private List<Gem> gems = new ArrayList<>();
    private DocumentBuilder documentBuilder;

    public GemDOMParser(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException err) {
            LOGGER.error("Configuration error "+ err.getMessage());
        }
    }

    public List<Gem> parse(String path) throws DOMParserException {
        Document doc;
        try {
            doc = documentBuilder.parse(path);
            Element root = doc.getDocumentElement();
            NodeList preciousList = root.getElementsByTagName("precious");
            NodeList semipreciousList = root.getElementsByTagName("semiprecious");
            for (int i = 0; i < preciousList.getLength(); i++) {
                Element preciousElement = (Element) preciousList.item(i);
                try {
                    PreciousStone preciousStone = (PreciousStone) buildGemObject(preciousElement);
                    gems.add(preciousStone);
                }catch (WrongDataException err){
                    LOGGER.error(err.getMessage());
                }
            }
                for (int i = 0; i < semipreciousList.getLength(); i++) {
                    Element semipreciousElement = (Element) semipreciousList.item(i);
                    try {
                        SemipreciousStone semipreciousStone = (SemipreciousStone) buildGemObject(semipreciousElement);
                        gems.add(semipreciousStone);
                    }catch (WrongDataException err){
                        LOGGER.error(err.getMessage());
                    }
            }
        } catch (IOException err) {
            throw new DOMParserException("File error or I/O error: " + err.getMessage());
        } catch (SAXException err) {
            throw new DOMParserException("Parsing error: " + err.getMessage());
        }
        return gems;
    }

    private Gem buildGemObject(Element element) throws WrongDataException {
        Gem stone;
        switch (element.getTagName()) {
            case "precious":
                stone = new PreciousStone();
                ((PreciousStone) stone).setRarity(getElementTextContent(element,"rarity"));
                break;
            case "semiprecious":
                stone = new SemipreciousStone();
                ((SemipreciousStone) stone).setPrice(Double.parseDouble(getElementTextContent(element,"price")));
                break;
            default: throw new WrongDataException("wrong element or nothing supplied");
        }
        stone.setName(element.getAttribute("name"));
        stone.setPreciousness(getElementTextContent(element,"preciousness"));
        stone.setOrigin(getElementTextContent(element,"origin"));
        Element vpElement = (Element) element.getElementsByTagName("visual-parameters").item(0);
        stone.getVisualParameters().setTransparency(Integer.parseInt(getElementTextContent(vpElement,"transparency")));
        stone.getVisualParameters().setColor(getElementTextContent(vpElement,"color"));
        stone.getVisualParameters().setLustre(getElementTextContent(vpElement,"lustre"));
        stone.setValue(Double.parseDouble(getElementTextContent(element,"value")));
        stone.setHardness(Double.parseDouble(getElementTextContent(element,"hardness")));
        return stone;
    }
    private String getElementTextContent(Element element, String name){
        Node temp=element.getElementsByTagName(name).item(0);
        return temp.getTextContent();
    }
}
