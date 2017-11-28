package main.java.com.epam.entity;

import main.java.com.epam.list.ProductList;

public class ProductListPojo {
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
        return "ClassPojo [ProductList = " + productList + "]";
    }
}
