package main.java.com.epam.entity;

import main.java.com.epam.list.ProductList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;
import java.util.List;

@XmlSeeAlso(Product.class)
@XmlRootElement
public class ProductListPojo implements Serializable {
    List<ProductList> objectList;

    public List<ProductList> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<ProductList> objectList) {
        this.objectList = objectList;
    }
}
