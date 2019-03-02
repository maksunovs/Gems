package com.epam.gems.entity;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="PreciousStone", namespace="http://www.example.com/gems")
@XmlRootElement(name="precious", namespace="http://www.example.com/gems")
public class PreciousStone extends Gem {
    public PreciousStone(){

    }
    public PreciousStone(String name, String origin, VisualParameters visualParameters, double value, double hardness) {
        super(name, origin, visualParameters, value, hardness);
    }
    @Override
    public String toString(){
        return  "PreciousStone{" +
                "name='" + getName() + '\'' +
                ", origin='" + getOrigin() + '\'' +
                ", visualParameters=" + getVisualParameters() +
                ", value=" + getValue() +
                ", hardness=" + getHardness() +
                '}';
    }

}
