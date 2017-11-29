package main.java.com.epam.list;

import main.java.com.epam.entity.Product;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlSeeAlso(Product.class)
@XmlRootElement(name = "PRODUCTList")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductList implements Serializable {
    @XmlElement(name = "PRODUCT")
    private List<Product> products;

    public List<Product> getProducts()
    {
        return products;
    }

    public void setProducts(List<Product> products)
    {
        this.products = products;
    }

    @Override
    public String toString()
    {
        StringBuffer result = new StringBuffer();

        for(int i = 0; i < products.size(); i++) {
            result.append(products.get(i).toString()).append("\n");
        }

        return result.toString();
    }
}
