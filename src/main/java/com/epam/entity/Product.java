package main.java.com.epam.entity;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Objects;

@XmlRootElement(name = "PRODUCT")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product implements Serializable {
    @XmlElement(name = "ID")
    private int id;
    @XmlElement(name = "NAME")
    private String name;
    @XmlElement(name = "PRICE")
    private double price;

    public Product() {}

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Product)) {
            return false;
        }
        Product product = (Product) obj;
        return id == product.id &&
                Objects.equals(name, product.name) &&
                price == product.price;
    }
}
