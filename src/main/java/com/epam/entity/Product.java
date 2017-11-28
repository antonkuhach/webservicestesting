package main.java.com.epam.entity;

public class Product {
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
        return "ClassPojo [content = " + content + "]";
    }
}
