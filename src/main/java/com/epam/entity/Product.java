package main.java.com.epam.entity;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "PRODUCT")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product implements Serializable {
    private String content;
    private String href;

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString()
    {
        return "Product content: " + content + ". Link: "+ href + "\n";
    }
}
