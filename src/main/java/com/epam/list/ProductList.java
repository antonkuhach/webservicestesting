package main.java.com.epam.list;

import main.java.com.epam.entity.Product;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlSeeAlso(Product.class)
@XmlRootElement(name = "PRODUCTList")
public class ProductList implements Serializable {
    private List<Product> product;

    public List<Product> getProduct()
    {
        return product;
    }

    public void setProduct(List<Product> product)
    {
        this.product = product;
    }

    @Override
    public String toString()
    {
        StringBuffer result = new StringBuffer();

        for(int i = 0; i < product.size(); i++) {
            result.append(product.get(i).toString());
        }

        return result.toString();
    }
}
