package main.java.com.epam.entity;

import main.java.com.epam.list.ProductList;

import java.io.Serializable;

public class ProductListPojo implements Serializable {
    private ProductList productList;

    public ProductList getProductList()
    {
        return productList;
    }

    public void setProductList(ProductList productList)
    {
        this.productList = productList;
    }

    @Override
    public String toString()
    {
        return "ProductList:\n" + productList.toString();
    }
}
