package com.epam.gems.entity;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SemipreciousStone", namespace = "http://www.example.com/gems")
@XmlRootElement(name = "semiprecious", namespace = "http://www.example.com/gems")
public class SemipreciousStone extends Gem {
    @XmlElement(name = "price", namespace = "http://www.example.com/gems")
    private double price;

    public SemipreciousStone() {
    }

    public SemipreciousStone(String name, String preciousness, String origin, VisualParameters visualParameters, double value, double hardness, int price) {
        super(name, preciousness, origin, visualParameters, value, hardness);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SemipreciousStone semipreciousStone = (SemipreciousStone) o;
        return getName().equals(semipreciousStone.getName()) &&
                getPreciousness().equals(semipreciousStone.getPreciousness()) &&
                getOrigin().equals(semipreciousStone.getOrigin()) &&
                getVisualParameters().equals(semipreciousStone.getVisualParameters()) &&
                getValue() == semipreciousStone.getValue() &&
                getHardness() == semipreciousStone.getHardness() &&
                this.price == semipreciousStone.price;
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
        result = result * prime + (int) price;
        return result * prime;
    }

    @Override
    public String toString() {
        return "SemipreciousStone{" +
                "price=" + price +
                ", name=" + getName() +
                ", preciousness=" + getPreciousness() +
                ", origin=" + getOrigin() +
                ", visualParameters=" + getVisualParameters() +
                ", value=" + getValue() +
                ", hardness=" + getHardness() +
                '}';
    }
}
