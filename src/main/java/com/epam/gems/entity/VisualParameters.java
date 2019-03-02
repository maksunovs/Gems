package com.epam.gems.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="VisualParameters",propOrder = {
        "preciousness",
        "color",
        "lustre"
})
public class VisualParameters {
    @XmlElement(namespace="http://www.example.com/gems")
    private String preciousness;
    @XmlElement(namespace="http://www.example.com/gems")
    private String color;
    @XmlElement(namespace="http://www.example.com/gems")
    private String lustre;
    public VisualParameters(){}
    public VisualParameters(String preciousness, String color, String lustre) {
        this.preciousness = preciousness;
        this.color = color;
        this.lustre = lustre;
    }

    public String getPreciousness() {
        return preciousness;
    }

    public void setPreciousness(String preciousness) {
        this.preciousness = preciousness;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLustre() {
        return lustre;
    }

    public void setLustre(String lustre) {
        this.lustre = lustre;
    }

    @Override
    public String toString() {
        return "VisualParameters{" +
                "preciousness='" + preciousness + '\'' +
                ", color='" + color + '\'' +
                ", lustre='" + lustre + '\'' +
                '}';
    }
}
