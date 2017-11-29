package main.java.com.epam.list;

import main.java.com.epam.entity.Product;

import java.io.Serializable;

public class ProductList implements Serializable {
    private Product[] product;

    public Product[] getProduct()
    {
        return product;
    }

    public void setProduct(Product[] product)
    {
        this.product = product;
    }

    @Override
    public String toString()
    {
        StringBuffer result = new StringBuffer();

        for(int i = 0; i < product.length; i++) {
            result.append(product[i].toString());
        }

        return result.toString();
    }
}
