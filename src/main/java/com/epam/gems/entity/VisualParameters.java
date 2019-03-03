package com.epam.gems.entity;

import javax.xml.bind.annotation.*;
import java.awt.image.VolatileImage;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VisualParameters", propOrder = {
        "transparency",
        "color",
        "lustre"
})
@XmlRootElement(name = "visual-parameters", namespace = "http://www.example.com/gems")
public class VisualParameters {
    @XmlElement(name = "color", namespace = "http://www.example.com/gems")
    private String color;
    @XmlElement(name = "transparency", namespace = "http://www.example.com/gems")
    private int transparency;
    @XmlElement(name = "lustre", namespace = "http://www.example.com/gems")
    private String lustre;

    public VisualParameters() {
    }

    public VisualParameters(String color, int transparency, String lustre) {
        this.transparency = transparency;
        this.color = color;
        this.lustre = lustre;
    }

    public int getTransparency() {
        return transparency;
    }

    public void setTransparency(int transparency) {
        this.transparency = transparency;
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
    public boolean equals(Object o) {
        if (this == o) {
            return false;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VisualParameters visualParameters = (VisualParameters) o;
        return this.transparency == visualParameters.transparency &&
                this.color.equals(visualParameters.color) &&
                this.lustre.equals(visualParameters.lustre);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = result * prime + (int) transparency;
        result = result * prime + ((color == null) ? 0 : color.hashCode());
        result = result * prime + ((lustre == null) ? 0 : lustre.hashCode());
        return result * prime;
    }

    @Override
    public String toString() {
        return "VisualParameters{" +
                "transparency=" + transparency +
                ", color=" + color +
                ", lustre=" + lustre +
                '}';
    }
}
