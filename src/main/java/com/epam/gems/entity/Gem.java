package com.epam.gems.entity;


import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Gem", propOrder = {
        "name",
        "preciousness",
        "origin",
        "visualParameters",
        "value",
        "hardness"
})
@XmlSeeAlso({PreciousStone.class, SemipreciousStone.class})

public abstract class Gem {

    @XmlAttribute(name = "name")
    private String name;
    @XmlElement(namespace = "http://www.example.com/gems")
    private String preciousness;
    @XmlElement(namespace = "http://www.example.com/gems")
    private String origin;
    @XmlElement(name = "visual-parameters", namespace = "http://www.example.com/gems")
    private VisualParameters visualParameters;
    @XmlElement(namespace = "http://www.example.com/gems")
    private double value;
    @XmlElement(namespace = "http://www.example.com/gems")
    private double hardness;

    public Gem() {
        visualParameters = new VisualParameters();
    }

    public Gem(String name, String preciousness, String origin, VisualParameters visualParameters, double value, double hardness) {
        this.name = name;
        this.preciousness = preciousness;
        this.origin = origin;
        this.visualParameters = visualParameters;
        this.value = value;
        this.hardness = hardness;
    }

    public String getName() {
        return name;
    }

    public String getOrigin() {
        return origin;
    }

    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    public double getValue() {
        return value;
    }

    public double getHardness() {
        return hardness;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setVisualParameters(VisualParameters visualParameters) {
        this.visualParameters = visualParameters;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setHardness(double hardness) {
        this.hardness = hardness;
    }

    public String getPreciousness() {
        return preciousness;
    }

    public void setPreciousness(String preciousness) {
        this.preciousness = preciousness;
    }

    @Override
    public String toString() {
        return "Gem{" +
                "name=" + name +
                ", preciousness=" + preciousness +
                ", origin=" + origin +
                ", visualParameters=" + visualParameters +
                ", value=" + value +
                ", hardness=" + hardness +
                '}';
    }
}
