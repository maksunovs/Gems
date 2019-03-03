package com.epam.gems.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"list"})
@XmlRootElement(name = "gems", namespace = "http://www.example.com/gems")
public class Gems {
    @XmlElementRefs(value = {@XmlElementRef(name = "precious", type = PreciousStone.class, namespace = "http://www.example.com/gems"),
            @XmlElementRef(name = "semiprecious", type = SemipreciousStone.class, namespace = "http://www.example.com/gems")})
    public List<Gem> list = new ArrayList<>();

    public Gems() {
    }

    public List<Gem> getList() {
        return list;
    }
}
