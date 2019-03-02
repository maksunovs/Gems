package com.epam.gems.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="SemipreciousStone", namespace="http://www.example.com/gems")
@XmlRootElement(name="semiprecious",namespace="http://www.example.com/gems")
public class SemipreciousStone extends Gem{
    public SemipreciousStone(){

    }
    public SemipreciousStone(String name, String origin, VisualParameters visualParameters, double value, double hardness) {
        super(name, origin, visualParameters, value, hardness);
    }

    @Override
    public String toString() {
        return"SemipreciousStone{" +
                "name='" + getName() + '\'' +
                ", origin='" + getOrigin() + '\'' +
                ", visualParameters=" + getVisualParameters() +
                ", value=" + getValue() +
                ", hardness=" + getHardness() +
                '}';
    }
}
