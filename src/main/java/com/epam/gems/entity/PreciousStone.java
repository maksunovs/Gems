package com.epam.gems.entity;


import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PreciousStone", namespace = "http://www.example.com/gems")
@XmlRootElement(name = "precious", namespace = "http://www.example.com/gems")
public class PreciousStone extends Gem {
    @XmlElement(name = "rarity", namespace = "http://www.example.com/gems")
    private String rarity;

    public PreciousStone() {

    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public PreciousStone(String name, String preciousness, String origin, VisualParameters visualParameters, double value, double hardness, String rarity) {
        super(name, preciousness, origin, visualParameters, value, hardness);
        this.rarity = rarity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PreciousStone preciousStone = (PreciousStone) o;
        return getName().equals(preciousStone.getName()) &&
                getPreciousness().equals(preciousStone.getPreciousness()) &&
                getOrigin().equals(preciousStone.getOrigin()) &&
                getVisualParameters().equals(preciousStone.getVisualParameters()) &&
                getValue() == preciousStone.getValue() &&
                getHardness() == preciousStone.getHardness() &&
                this.rarity.equals(preciousStone.rarity);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = result * prime + ((getName() == null) ? 0 : getName().hashCode());
        result = result * prime + ((getPreciousness() == null) ? 0 : getPreciousness().hashCode());
        result = result * prime + ((getOrigin() == null) ? 0 : getOrigin().hashCode());
        result = result * prime + ((getVisualParameters() == null) ? 0 : getVisualParameters().hashCode());
        result = result * prime + (int) getValue();
        result = result * prime + (int) getHardness();
        result = result * prime + ((rarity == null) ? 0 : rarity.hashCode());
        return result * prime;
    }

    @Override
    public String toString() {
        return "PreciousStone{" +
                "name=" + getName() +
                ", preciousness=" + getPreciousness() +
                ", origin=" + getOrigin() +
                ", visualParameters=" + getVisualParameters() +
                ", value=" + getValue() +
                ", hardness=" + getHardness() +
                ", rarity=" + rarity +
                '}';
    }

}
