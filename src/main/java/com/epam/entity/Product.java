package main.java.com.epam.entity;

import java.io.Serializable;

public class Product implements Serializable {
    private String content;

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    @Override
    public String toString()
    {
        return "Product content: " + content + "\n";
    }
}
