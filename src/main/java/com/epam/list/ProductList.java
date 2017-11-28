package main.java.com.epam.list;

import main.java.com.epam.entity.Product;

public class ProductList {
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
        return "ClassPojo [Product = " + product + "]";
    }
}
