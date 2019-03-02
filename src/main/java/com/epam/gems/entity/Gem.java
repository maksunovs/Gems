package com.epam.gems.entity;



import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Gem",propOrder = {
        "name",
        "origin",
        "visualParameters",
        "value",
        "hardness"
})
@XmlSeeAlso( {PreciousStone.class, SemipreciousStone.class,VisualParameters.class})

public abstract class Gem {

    @XmlAttribute(name="name")
    private String name;
    @XmlElement(namespace="http://www.example.com/gems")
    private String origin;
    @XmlElement(required = true)
    private VisualParameters visualParameters;
    @XmlElement(namespace="http://www.example.com/gems")
    private double value;
    @XmlElement(namespace="http://www.example.com/gems")
    private double hardness;

    public Gem() {
    }

    public Gem(String name, String origin, VisualParameters visualParameters, double value, double hardness) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Gem{" +
                "name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", visualParameters=" + visualParameters +
                ", value=" + value +
                ", hardness=" + hardness +
                '}';
    }
}
