package main.java.com.epam.entity;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "PRODUCT")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product implements Serializable {
    @XmlElement(name = "ID")
    private int id;
    @XmlElement(name = "NAME")
    private String name;
    @XmlElement(name = "PRICE")
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString()
    {
        StringBuffer result = new StringBuffer();

        result.append("Product '").append(name)
                .append("' id: ").append(id)
                .append(". Price: ").append(price);

        return result.toString();
    }
}
